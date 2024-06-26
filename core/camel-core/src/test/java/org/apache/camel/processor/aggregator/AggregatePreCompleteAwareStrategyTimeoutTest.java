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
package org.apache.camel.processor.aggregator;

import org.apache.camel.ContextTestSupport;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.BodyInPreCompleteAggregatingStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;

@Isolated("Does not play well with parallel execution")
public class AggregatePreCompleteAwareStrategyTimeoutTest extends ContextTestSupport {

    @Test
    public void testAggregatePreCompleteTimeout() throws Exception {
        getMockEndpoint("mock:aggregated").expectedBodiesReceived("A+B+C", "X+D+E", "X+F");

        template.sendBodyAndHeader("direct:start", "A", "id", 123);
        template.sendBodyAndHeader("direct:start", "B", "id", 123);
        template.sendBodyAndHeader("direct:start", "C", "id", 123);
        template.sendBodyAndHeader("direct:start", "X", "id", 123);
        template.sendBodyAndHeader("direct:start", "D", "id", 123);
        template.sendBodyAndHeader("direct:start", "E", "id", 123);
        template.sendBodyAndHeader("direct:start", "X", "id", 123);
        template.sendBodyAndHeader("direct:start", "F", "id", 123);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void testAggregatePreCompleteTimeoutOnlyOneInLastGroup() throws Exception {
        getMockEndpoint("mock:aggregated").expectedBodiesReceived("A+B+C", "X+D+E", "X");

        template.sendBodyAndHeader("direct:start", "A", "id", 123);
        template.sendBodyAndHeader("direct:start", "B", "id", 123);
        template.sendBodyAndHeader("direct:start", "C", "id", 123);
        template.sendBodyAndHeader("direct:start", "X", "id", 123);
        template.sendBodyAndHeader("direct:start", "D", "id", 123);
        template.sendBodyAndHeader("direct:start", "E", "id", 123);
        template.sendBodyAndHeader("direct:start", "X", "id", 123);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void testAggregatePreCompleteTimeoutOnlyOneInFirstGroup() throws Exception {
        getMockEndpoint("mock:aggregated").expectedBodiesReceived("X");

        template.sendBodyAndHeader("direct:start", "X", "id", 123);

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:start").aggregate(header("id"), new BodyInPreCompleteAggregatingStrategy()).completionTimeout(100)
                        .completionTimeoutCheckerInterval(10)
                        .to("mock:aggregated");
            }
        };
    }
}
