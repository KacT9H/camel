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
package org.apache.camel.component.pulsar.integration;

import java.util.concurrent.TimeUnit;

import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.component.pulsar.PulsarComponent;
import org.apache.camel.component.pulsar.PulsarMessageReceipt;
import org.apache.camel.component.pulsar.utils.AutoConfiguration;
import org.apache.camel.component.pulsar.utils.message.PulsarMessageHeaders;
import org.apache.camel.spi.Registry;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.impl.ClientBuilderImpl;
import org.apache.pulsar.client.impl.MultiplierRedeliveryBackoff;
import org.junit.jupiter.api.Test;

public class PulsarConsumerNegativeAcknowledgementIT extends PulsarITSupport {

    private static final String TOPIC_URI = "persistent://public/default/camel-topic-negative-ack";
    private static final String PRODUCER = "camel-producer-1";

    @EndpointInject("pulsar:" + TOPIC_URI + "?numberOfConsumers=1&subscriptionType=Exclusive&batchingEnabled=false"
                    + "&subscriptionName=camel-subscription&consumerQueueSize=1&consumerName=camel-consumer")
    private Endpoint from;

    @EndpointInject("mock:result")
    private MockEndpoint to;

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                // This route will explicitly negative acknowledge the message.
                from(from)
                        .process(exchange -> exchange.getIn()
                                .getHeader(PulsarMessageHeaders.MESSAGE_RECEIPT, PulsarMessageReceipt.class)
                                .negativeAcknowledge())
                        .to(to);
            }
        };
    }

    @Override
    protected void bindToRegistry(Registry registry) throws Exception {
        registerPulsarBeans(registry);
    }

    private void registerPulsarBeans(Registry registry) throws PulsarClientException {
        PulsarClient pulsarClient = givenPulsarClient();
        AutoConfiguration autoConfiguration = new AutoConfiguration(null, null);

        registry.bind("pulsarClient", pulsarClient);
        PulsarComponent comp = new PulsarComponent(context);
        comp.setAutoConfiguration(autoConfiguration);
        comp.setPulsarClient(pulsarClient);
        comp.getConfiguration()
                .setAllowManualAcknowledgement(true); // Set to true here instead of the endpoint query parameter.
        comp.getConfiguration().setAckTimeoutMillis(60_000L);
        // Given relevant millis=1000 redeliveries will occur at 1s + 0.01s, 1s + 1s, 1s + 100s, 1s + 100s, 1s + 100s...
        comp.getConfiguration().setNegativeAckRedeliveryDelayMicros(1_000_000L);
        comp.getConfiguration().setNegativeAckRedeliveryBackoff(MultiplierRedeliveryBackoff.builder()
                .minDelayMs(10L)
                .maxDelayMs(100_000L)
                .multiplier(100.0)
                .build());
        registry.bind("pulsar", comp);
    }

    private PulsarClient givenPulsarClient() throws PulsarClientException {
        return new ClientBuilderImpl().serviceUrl(getPulsarBrokerUrl()).ioThreads(1).listenerThreads(1).build();
    }

    @Test
    public void testAMessageIsConsumedMultipleTimesWithNegativeAckBackoff() throws Exception {
        to.expectedMessageCount(3);

        Producer<String> producer
                = givenPulsarClient().newProducer(Schema.STRING).producerName(PRODUCER).topic(TOPIC_URI).create();

        producer.send("Hello World!");

        MockEndpoint.assertIsSatisfied(10, TimeUnit.SECONDS, to);

        producer.close();
    }
}
