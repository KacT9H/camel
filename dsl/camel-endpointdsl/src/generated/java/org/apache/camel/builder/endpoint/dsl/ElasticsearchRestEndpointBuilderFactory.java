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
package org.apache.camel.builder.endpoint.dsl;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import javax.annotation.processing.Generated;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * Send requests to ElasticSearch via REST API
 * 
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface ElasticsearchRestEndpointBuilderFactory {


    /**
     * Builder for endpoint for the Elasticsearch Rest component.
     */
    public interface ElasticsearchRestEndpointBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedElasticsearchRestEndpointBuilder advanced() {
            return (AdvancedElasticsearchRestEndpointBuilder) this;
        }
        /**
         * The time in ms to wait before connection will timeout.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 30000
         * Group: producer
         * 
         * @param connectionTimeout the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder connectionTimeout(
                int connectionTimeout) {
            doSetProperty("connectionTimeout", connectionTimeout);
            return this;
        }
        /**
         * The time in ms to wait before connection will timeout.
         * 
         * The option will be converted to a &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 30000
         * Group: producer
         * 
         * @param connectionTimeout the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder connectionTimeout(
                String connectionTimeout) {
            doSetProperty("connectionTimeout", connectionTimeout);
            return this;
        }
        /**
         * Disconnect after it finish calling the producer.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param disconnect the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder disconnect(boolean disconnect) {
            doSetProperty("disconnect", disconnect);
            return this;
        }
        /**
         * Disconnect after it finish calling the producer.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param disconnect the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder disconnect(String disconnect) {
            doSetProperty("disconnect", disconnect);
            return this;
        }
        /**
         * Starting index of the response.
         * 
         * The option is a: &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param from the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder from(Integer from) {
            doSetProperty("from", from);
            return this;
        }
        /**
         * Starting index of the response.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param from the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder from(String from) {
            doSetProperty("from", from);
            return this;
        }
        /**
         * Comma separated list with ip:port formatted remote transport
         * addresses to use.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param hostAddresses the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder hostAddresses(
                String hostAddresses) {
            doSetProperty("hostAddresses", hostAddresses);
            return this;
        }
        /**
         * The name of the index to act against.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param indexName the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder indexName(String indexName) {
            doSetProperty("indexName", indexName);
            return this;
        }
        /**
         * The time in ms before retry.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 30000
         * Group: producer
         * 
         * @param maxRetryTimeout the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder maxRetryTimeout(
                int maxRetryTimeout) {
            doSetProperty("maxRetryTimeout", maxRetryTimeout);
            return this;
        }
        /**
         * The time in ms before retry.
         * 
         * The option will be converted to a &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 30000
         * Group: producer
         * 
         * @param maxRetryTimeout the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder maxRetryTimeout(
                String maxRetryTimeout) {
            doSetProperty("maxRetryTimeout", maxRetryTimeout);
            return this;
        }
        /**
         * What operation to perform.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.elasticsearch.ElasticsearchOperation&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param operation the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder operation(
                org.apache.camel.component.elasticsearch.ElasticsearchOperation operation) {
            doSetProperty("operation", operation);
            return this;
        }
        /**
         * What operation to perform.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.component.elasticsearch.ElasticsearchOperation&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param operation the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder operation(String operation) {
            doSetProperty("operation", operation);
            return this;
        }
        /**
         * Time in ms during which elasticsearch will keep search context alive.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 60000
         * Group: producer
         * 
         * @param scrollKeepAliveMs the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder scrollKeepAliveMs(
                int scrollKeepAliveMs) {
            doSetProperty("scrollKeepAliveMs", scrollKeepAliveMs);
            return this;
        }
        /**
         * Time in ms during which elasticsearch will keep search context alive.
         * 
         * The option will be converted to a &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 60000
         * Group: producer
         * 
         * @param scrollKeepAliveMs the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder scrollKeepAliveMs(
                String scrollKeepAliveMs) {
            doSetProperty("scrollKeepAliveMs", scrollKeepAliveMs);
            return this;
        }
        /**
         * Size of the response.
         * 
         * The option is a: &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param size the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder size(Integer size) {
            doSetProperty("size", size);
            return this;
        }
        /**
         * Size of the response.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param size the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder size(String size) {
            doSetProperty("size", size);
            return this;
        }
        /**
         * The timeout in ms to wait before the socket will timeout.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 30000
         * Group: producer
         * 
         * @param socketTimeout the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder socketTimeout(int socketTimeout) {
            doSetProperty("socketTimeout", socketTimeout);
            return this;
        }
        /**
         * The timeout in ms to wait before the socket will timeout.
         * 
         * The option will be converted to a &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 30000
         * Group: producer
         * 
         * @param socketTimeout the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder socketTimeout(
                String socketTimeout) {
            doSetProperty("socketTimeout", socketTimeout);
            return this;
        }
        /**
         * Enable scroll usage.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param useScroll the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder useScroll(boolean useScroll) {
            doSetProperty("useScroll", useScroll);
            return this;
        }
        /**
         * Enable scroll usage.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param useScroll the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder useScroll(String useScroll) {
            doSetProperty("useScroll", useScroll);
            return this;
        }
        /**
         * Index creation waits for the write consistency number of shards to be
         * available.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 1
         * Group: producer
         * 
         * @param waitForActiveShards the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder waitForActiveShards(
                int waitForActiveShards) {
            doSetProperty("waitForActiveShards", waitForActiveShards);
            return this;
        }
        /**
         * Index creation waits for the write consistency number of shards to be
         * available.
         * 
         * The option will be converted to a &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 1
         * Group: producer
         * 
         * @param waitForActiveShards the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder waitForActiveShards(
                String waitForActiveShards) {
            doSetProperty("waitForActiveShards", waitForActiveShards);
            return this;
        }
        /**
         * Enable SSL.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: security
         * 
         * @param enableSSL the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder enableSSL(boolean enableSSL) {
            doSetProperty("enableSSL", enableSSL);
            return this;
        }
        /**
         * Enable SSL.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: security
         * 
         * @param enableSSL the value to set
         * @return the dsl builder
         */
        default ElasticsearchRestEndpointBuilder enableSSL(String enableSSL) {
            doSetProperty("enableSSL", enableSSL);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Elasticsearch Rest component.
     */
    public interface AdvancedElasticsearchRestEndpointBuilder
            extends
                EndpointProducerBuilder {
        default ElasticsearchRestEndpointBuilder basic() {
            return (ElasticsearchRestEndpointBuilder) this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer (advanced)
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default AdvancedElasticsearchRestEndpointBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: producer (advanced)
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default AdvancedElasticsearchRestEndpointBuilder lazyStartProducer(
                String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Enable automatically discover nodes from a running Elasticsearch
         * cluster. If this option is used in conjunction with Spring Boot then
         * it's managed by the Spring Boot configuration (see: Disable Sniffer
         * in Spring Boot).
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: advanced
         * 
         * @param enableSniffer the value to set
         * @return the dsl builder
         */
        default AdvancedElasticsearchRestEndpointBuilder enableSniffer(
                boolean enableSniffer) {
            doSetProperty("enableSniffer", enableSniffer);
            return this;
        }
        /**
         * Enable automatically discover nodes from a running Elasticsearch
         * cluster. If this option is used in conjunction with Spring Boot then
         * it's managed by the Spring Boot configuration (see: Disable Sniffer
         * in Spring Boot).
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: advanced
         * 
         * @param enableSniffer the value to set
         * @return the dsl builder
         */
        default AdvancedElasticsearchRestEndpointBuilder enableSniffer(
                String enableSniffer) {
            doSetProperty("enableSniffer", enableSniffer);
            return this;
        }
        /**
         * The delay of a sniff execution scheduled after a failure (in
         * milliseconds).
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 60000
         * Group: advanced
         * 
         * @param sniffAfterFailureDelay the value to set
         * @return the dsl builder
         */
        default AdvancedElasticsearchRestEndpointBuilder sniffAfterFailureDelay(
                int sniffAfterFailureDelay) {
            doSetProperty("sniffAfterFailureDelay", sniffAfterFailureDelay);
            return this;
        }
        /**
         * The delay of a sniff execution scheduled after a failure (in
         * milliseconds).
         * 
         * The option will be converted to a &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 60000
         * Group: advanced
         * 
         * @param sniffAfterFailureDelay the value to set
         * @return the dsl builder
         */
        default AdvancedElasticsearchRestEndpointBuilder sniffAfterFailureDelay(
                String sniffAfterFailureDelay) {
            doSetProperty("sniffAfterFailureDelay", sniffAfterFailureDelay);
            return this;
        }
        /**
         * The interval between consecutive ordinary sniff executions in
         * milliseconds. Will be honoured when sniffOnFailure is disabled or
         * when there are no failures between consecutive sniff executions.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 300000
         * Group: advanced
         * 
         * @param snifferInterval the value to set
         * @return the dsl builder
         */
        default AdvancedElasticsearchRestEndpointBuilder snifferInterval(
                int snifferInterval) {
            doSetProperty("snifferInterval", snifferInterval);
            return this;
        }
        /**
         * The interval between consecutive ordinary sniff executions in
         * milliseconds. Will be honoured when sniffOnFailure is disabled or
         * when there are no failures between consecutive sniff executions.
         * 
         * The option will be converted to a &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 300000
         * Group: advanced
         * 
         * @param snifferInterval the value to set
         * @return the dsl builder
         */
        default AdvancedElasticsearchRestEndpointBuilder snifferInterval(
                String snifferInterval) {
            doSetProperty("snifferInterval", snifferInterval);
            return this;
        }
    }

    public interface ElasticsearchRestBuilders {
        /**
         * Elasticsearch Rest (camel-elasticsearch-rest)
         * Send requests to ElasticSearch via REST API
         * 
         * Category: search,monitoring
         * Since: 2.21
         * Maven coordinates: org.apache.camel:camel-elasticsearch-rest
         * 
         * @return the dsl builder for the headers' name.
         */
        default ElasticsearchRestHeaderNameBuilder elasticsearchRest() {
            return ElasticsearchRestHeaderNameBuilder.INSTANCE;
        }
        /**
         * Elasticsearch Rest (camel-elasticsearch-rest)
         * Send requests to ElasticSearch via REST API
         * 
         * Category: search,monitoring
         * Since: 2.21
         * Maven coordinates: org.apache.camel:camel-elasticsearch-rest
         * 
         * Syntax: <code>elasticsearch-rest:clusterName</code>
         * 
         * Path parameter: clusterName (required)
         * Name of the cluster
         * 
         * @param path clusterName
         * @return the dsl builder
         */
        @Deprecated
        default ElasticsearchRestEndpointBuilder elasticsearchRest(String path) {
            return ElasticsearchRestEndpointBuilderFactory.endpointBuilder("elasticsearch-rest", path);
        }
        /**
         * Elasticsearch Rest (camel-elasticsearch-rest)
         * Send requests to ElasticSearch via REST API
         * 
         * Category: search,monitoring
         * Since: 2.21
         * Maven coordinates: org.apache.camel:camel-elasticsearch-rest
         * 
         * Syntax: <code>elasticsearch-rest:clusterName</code>
         * 
         * Path parameter: clusterName (required)
         * Name of the cluster
         * 
         * @param componentName to use a custom component name for the endpoint
         * instead of the default name
         * @param path clusterName
         * @return the dsl builder
         */
        @Deprecated
        default ElasticsearchRestEndpointBuilder elasticsearchRest(
                String componentName,
                String path) {
            return ElasticsearchRestEndpointBuilderFactory.endpointBuilder(componentName, path);
        }
    }

    /**
     * The builder of headers' name for the Elasticsearch Rest component.
     */
    public static class ElasticsearchRestHeaderNameBuilder {
        /**
         * The internal instance of the builder used to access to all the
         * methods representing the name of headers.
         */
        private static final ElasticsearchRestHeaderNameBuilder INSTANCE = new ElasticsearchRestHeaderNameBuilder();

        /**
         * The operation to perform.
         * 
         * The option is a: {@code
         * org.apache.camel.component.elasticsearch.ElasticsearchOperation}
         * type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code operation}.
         */
        public String operation() {
            return "operation";
        }

        /**
         * The id of the indexed document.
         * 
         * The option is a: {@code String} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code indexId}.
         */
        public String indexId() {
            return "indexId";
        }

        /**
         * The name of the index to act against.
         * 
         * The option is a: {@code String} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code indexName}.
         */
        public String indexName() {
            return "indexName";
        }

        /**
         * The index creation waits for the write consistency number of shards
         * to be available.
         * 
         * The option is a: {@code Integer} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code waitForActiveShards}.
         */
        public String waitForActiveShards() {
            return "waitForActiveShards";
        }

        /**
         * The starting index of the response.
         * 
         * The option is a: {@code Integer} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code scrollKeepAliveMs}.
         */
        public String scrollKeepAliveMs() {
            return "scrollKeepAliveMs";
        }

        /**
         * Set to true to enable scroll usage.
         * 
         * The option is a: {@code Boolean} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code useScroll}.
         */
        public String useScroll() {
            return "useScroll";
        }

        /**
         * The size of the response.
         * 
         * The option is a: {@code Integer} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code size}.
         */
        public String size() {
            return "size";
        }

        /**
         * The starting index of the response.
         * 
         * The option is a: {@code Integer} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code from}.
         */
        public String from() {
            return "from";
        }
    }
    @Deprecated
    static ElasticsearchRestEndpointBuilder endpointBuilder(
            String componentName,
            String path) {
        class ElasticsearchRestEndpointBuilderImpl extends AbstractEndpointBuilder implements ElasticsearchRestEndpointBuilder, AdvancedElasticsearchRestEndpointBuilder {
            public ElasticsearchRestEndpointBuilderImpl(String path) {
                super(componentName, path);
            }
        }
        return new ElasticsearchRestEndpointBuilderImpl(path);
    }
}