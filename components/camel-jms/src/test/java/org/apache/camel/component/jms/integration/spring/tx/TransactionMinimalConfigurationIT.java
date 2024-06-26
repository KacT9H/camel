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
package org.apache.camel.component.jms.integration.spring.tx;

import org.apache.camel.Exchange;
import org.apache.camel.component.jms.integration.spring.AbstractSpringJMSITSupport;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * To demonstrate transacted with minimal configuration.
 */
@Tags({ @Tag("not-parallel"), @Tag("spring"), @Tag("tx") })
public class TransactionMinimalConfigurationIT extends AbstractSpringJMSITSupport {

    @Override
    protected ClassPathXmlApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext(
                "/org/apache/camel/component/jms/integration/spring/tx/TransactionMinimalConfigurationIT.xml");
    }

    @Test
    public void testTransactionSuccess() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(1);
        mock.expectedBodiesReceived("Bye World");
        // success at 3rd attempt
        mock.message(0).header("count").isEqualTo(3);
        // since its JMS that does the redeliver we should test for that
        mock.message(0).header("JMSRedelivered").isEqualTo(true);
        // and not Camel doing the redelivery
        mock.message(0).header(Exchange.REDELIVERED).isNull();
        mock.message(0).header(Exchange.REDELIVERY_COUNTER).isNull();

        template.sendBody("activemq:queue:TransactionMinimalConfigurationTest", "Hello World");

        mock.assertIsSatisfied();
    }
}
