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

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.camel.ContextTestSupport;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.SynchronizationAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AsyncEndpointDelayUoWTest extends ContextTestSupport {

    private static String beforeThreadName;
    private static String afterThreadName;
    private final MySynchronization sync = new MySynchronization();

    @Test
    public void testAsyncEndpoint() throws Exception {
        getMockEndpoint("mock:before").expectedBodiesReceived("Hello Camel");
        getMockEndpoint("mock:after").expectedBodiesReceived("Bye Camel");
        getMockEndpoint("mock:result").expectedBodiesReceived("Bye Camel");

        String reply = template.requestBody("direct:start", "Hello Camel", String.class);
        assertEquals("Bye Camel", reply);

        assertMockEndpointsSatisfied();

        // wait a bit to ensure UoW has been run
        assertTrue(oneExchangeDone.matchesWaitTime());

        assertFalse(beforeThreadName.equalsIgnoreCase(afterThreadName), "Should use different threads");
        assertEquals(1, sync.isOnComplete());
        assertEquals(0, sync.isOnFailure());
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:start").process(new Processor() {
                    public void process(Exchange exchange) {
                        beforeThreadName = Thread.currentThread().getName();
                        exchange.getExchangeExtension().addOnCompletion(sync);
                    }
                }).to("mock:before").to("log:before").delay(500).asyncDelayed().process(new Processor() {
                    public void process(Exchange exchange) {
                        afterThreadName = Thread.currentThread().getName();
                    }
                }).transform().constant("Bye Camel").to("log:after").to("mock:after").to("mock:result");
            }
        };
    }

    private static class MySynchronization extends SynchronizationAdapter {

        private final AtomicInteger onComplete = new AtomicInteger();
        private final AtomicInteger onFailure = new AtomicInteger();

        @Override
        public void onComplete(Exchange exchange) {
            onComplete.incrementAndGet();
        }

        @Override
        public void onFailure(Exchange exchange) {
            onFailure.incrementAndGet();
        }

        public int isOnComplete() {
            return onComplete.get();
        }

        public int isOnFailure() {
            return onFailure.get();
        }

    }

}
