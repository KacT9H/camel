/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.processor.async;

import java.util.concurrent.atomic.LongAdder;

import org.apache.camel.ContextTestSupport;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AsyncEndpointRedeliveryErrorHandlerNonBlockedDelay2Test extends ContextTestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncEndpointRedeliveryErrorHandlerNonBlockedDelay2Test.class);

    private static final LongAdder attempt = new LongAdder();
    private static String beforeThreadName;
    private static String afterThreadName;

    @Test
    public void testRedelivery() throws Exception {
        MockEndpoint before = getMockEndpoint("mock:result");
        before.expectedBodiesReceived("World");

        MockEndpoint result = getMockEndpoint("mock:result");
        result.expectedBodiesReceived("Hello Camel");

        template.sendBody("seda:start", "World");

        assertMockEndpointsSatisfied();

        assertFalse(beforeThreadName.equalsIgnoreCase(afterThreadName), "Should use different threads");
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                context.addComponent("async", new MyAsyncComponent());

                errorHandler(defaultErrorHandler().maximumRedeliveries(5).redeliveryDelay(100).asyncDelayedRedelivery());

                from("seda:start").to("log:before").to("mock:before").process(new Processor() {
                    public void process(Exchange exchange) {
                        beforeThreadName = Thread.currentThread().getName();
                    }
                }).to("async:camel").process(new Processor() {
                    public void process(Exchange exchange) {
                        LOG.info("Processing at attempt {} {}", attempt, exchange);

                        String body = exchange.getIn().getBody(String.class);
                        if (body.contains("Camel")) {
                            attempt.increment();
                            if (attempt.intValue() <= 2) {
                                LOG.info("Processing failed will thrown an exception");
                                throw new IllegalArgumentException("Damn");
                            }
                        }

                        exchange.getIn().setBody("Hello " + body);
                        LOG.info("Processing at attempt {} complete {}", attempt, exchange);
                    }
                }).to("log:after").process(new Processor() {
                    public void process(Exchange exchange) {
                        afterThreadName = Thread.currentThread().getName();
                    }
                }).to("mock:result");
            }
        };
    }
}
