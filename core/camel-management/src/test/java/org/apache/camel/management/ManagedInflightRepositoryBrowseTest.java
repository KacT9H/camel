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
package org.apache.camel.management;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.openmbean.TabularData;

import org.apache.camel.builder.RouteBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.apache.camel.management.DefaultManagementObjectNameStrategy.TYPE_SERVICE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisabledOnOs(OS.AIX)
public class ManagedInflightRepositoryBrowseTest extends ManagementTestSupport {

    @Test
    public void testInflightRepository() throws Exception {
        getMockEndpoint("mock:result").expectedMessageCount(1);

        template.sendBody("direct:start", "Hello World");

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                context.getInflightRepository().setInflightBrowseEnabled(true);

                from("direct:start").routeId("foo")
                        .to("mock:a")
                        .process(exchange -> {
                            MBeanServer mbeanServer = getMBeanServer();
                            ObjectName name = getCamelObjectName(TYPE_SERVICE, "DefaultInflightRepository");

                            Integer size = (Integer) mbeanServer.getAttribute(name, "Size");
                            assertEquals(1, size.intValue());

                            Integer routeSize = (Integer) mbeanServer.invoke(name, "size", new Object[] { "foo" },
                                    new String[] { "java.lang.String" });
                            assertEquals(1, routeSize.intValue());

                            TabularData data = (TabularData) mbeanServer.invoke(name, "browse", null, null);
                            assertNotNull(data);

                            assertEquals(1, data.size());
                        }).id("myProcessor")
                        .to("mock:result");
            }
        };
    }

}
