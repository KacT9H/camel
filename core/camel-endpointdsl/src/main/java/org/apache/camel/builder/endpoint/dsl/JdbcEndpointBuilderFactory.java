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

import java.util.Map;
import javax.annotation.Generated;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * The jdbc component enables you to access databases through JDBC, where SQL
 * queries are sent in the message body.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface JdbcEndpointBuilderFactory {


    /**
     * Builder for endpoint for the JDBC component.
     */
    public interface JdbcEndpointBuilder extends EndpointProducerBuilder {
        default AdvancedJdbcEndpointBuilder advanced() {
            return (AdvancedJdbcEndpointBuilder) this;
        }
        /**
         * Name of DataSource to lookup in the Registry. If the name is
         * dataSource or default, then Camel will attempt to lookup a default
         * DataSource from the registry, meaning if there is a only one instance
         * of DataSource found, then this DataSource will be used.
         * The option is a <code>java.lang.String</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder dataSourceName(String dataSourceName) {
            setProperty("dataSourceName", dataSourceName);
            return this;
        }
        /**
         * Whether to allow using named parameters in the queries.
         * The option is a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder allowNamedParameters(
                boolean allowNamedParameters) {
            setProperty("allowNamedParameters", allowNamedParameters);
            return this;
        }
        /**
         * Whether to allow using named parameters in the queries.
         * The option will be converted to a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder allowNamedParameters(
                String allowNamedParameters) {
            setProperty("allowNamedParameters", allowNamedParameters);
            return this;
        }
        /**
         * Specify the full package and class name to use as conversion when
         * outputType=SelectOne or SelectList.
         * The option is a <code>java.lang.String</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder outputClass(String outputClass) {
            setProperty("outputClass", outputClass);
            return this;
        }
        /**
         * Determines the output the producer should use.
         * The option is a
         * <code>org.apache.camel.component.jdbc.JdbcOutputType</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder outputType(JdbcOutputType outputType) {
            setProperty("outputType", outputType);
            return this;
        }
        /**
         * Determines the output the producer should use.
         * The option will be converted to a
         * <code>org.apache.camel.component.jdbc.JdbcOutputType</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder outputType(String outputType) {
            setProperty("outputType", outputType);
            return this;
        }
        /**
         * Optional parameters to the java.sql.Statement. For example to set
         * maxRows, fetchSize etc.
         * The option is a <code>java.util.Map&lt;java.lang.String,
         * java.lang.Object&gt;</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder parameters(Map<String, Object> parameters) {
            setProperty("parameters", parameters);
            return this;
        }
        /**
         * Optional parameters to the java.sql.Statement. For example to set
         * maxRows, fetchSize etc.
         * The option will be converted to a
         * <code>java.util.Map&lt;java.lang.String, java.lang.Object&gt;</code>
         * type.
         * @group producer
         */
        default JdbcEndpointBuilder parameters(String parameters) {
            setProperty("parameters", parameters);
            return this;
        }
        /**
         * The default maximum number of rows that can be read by a polling
         * query. The default value is 0.
         * The option is a <code>int</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder readSize(int readSize) {
            setProperty("readSize", readSize);
            return this;
        }
        /**
         * The default maximum number of rows that can be read by a polling
         * query. The default value is 0.
         * The option will be converted to a <code>int</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder readSize(String readSize) {
            setProperty("readSize", readSize);
            return this;
        }
        /**
         * Camel will set the autoCommit on the JDBC connection to be false,
         * commit the change after executed the statement and reset the
         * autoCommit flag of the connection at the end, if the resetAutoCommit
         * is true. If the JDBC connection doesn't support to reset the
         * autoCommit flag, you can set the resetAutoCommit flag to be false,
         * and Camel will not try to reset the autoCommit flag. When used with
         * XA transactions you most likely need to set it to false so that the
         * transaction manager is in charge of committing this tx.
         * The option is a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder resetAutoCommit(boolean resetAutoCommit) {
            setProperty("resetAutoCommit", resetAutoCommit);
            return this;
        }
        /**
         * Camel will set the autoCommit on the JDBC connection to be false,
         * commit the change after executed the statement and reset the
         * autoCommit flag of the connection at the end, if the resetAutoCommit
         * is true. If the JDBC connection doesn't support to reset the
         * autoCommit flag, you can set the resetAutoCommit flag to be false,
         * and Camel will not try to reset the autoCommit flag. When used with
         * XA transactions you most likely need to set it to false so that the
         * transaction manager is in charge of committing this tx.
         * The option will be converted to a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder resetAutoCommit(String resetAutoCommit) {
            setProperty("resetAutoCommit", resetAutoCommit);
            return this;
        }
        /**
         * Whether transactions are in use.
         * The option is a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder transacted(boolean transacted) {
            setProperty("transacted", transacted);
            return this;
        }
        /**
         * Whether transactions are in use.
         * The option will be converted to a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder transacted(String transacted) {
            setProperty("transacted", transacted);
            return this;
        }
        /**
         * To read BLOB columns as bytes instead of string data. This may be
         * needed for certain databases such as Oracle where you must read BLOB
         * columns as bytes.
         * The option is a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder useGetBytesForBlob(
                boolean useGetBytesForBlob) {
            setProperty("useGetBytesForBlob", useGetBytesForBlob);
            return this;
        }
        /**
         * To read BLOB columns as bytes instead of string data. This may be
         * needed for certain databases such as Oracle where you must read BLOB
         * columns as bytes.
         * The option will be converted to a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder useGetBytesForBlob(String useGetBytesForBlob) {
            setProperty("useGetBytesForBlob", useGetBytesForBlob);
            return this;
        }
        /**
         * Set this option to true to use the prepareStatementStrategy with
         * named parameters. This allows to define queries with named
         * placeholders, and use headers with the dynamic values for the query
         * placeholders.
         * The option is a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder useHeadersAsParameters(
                boolean useHeadersAsParameters) {
            setProperty("useHeadersAsParameters", useHeadersAsParameters);
            return this;
        }
        /**
         * Set this option to true to use the prepareStatementStrategy with
         * named parameters. This allows to define queries with named
         * placeholders, and use headers with the dynamic values for the query
         * placeholders.
         * The option will be converted to a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder useHeadersAsParameters(
                String useHeadersAsParameters) {
            setProperty("useHeadersAsParameters", useHeadersAsParameters);
            return this;
        }
        /**
         * Sets whether to use JDBC 4 or JDBC 3.0 or older semantic when
         * retrieving column name. JDBC 4.0 uses columnLabel to get the column
         * name where as JDBC 3.0 uses both columnName or columnLabel.
         * Unfortunately JDBC drivers behave differently so you can use this
         * option to work out issues around your JDBC driver if you get problem
         * using this component This option is default true.
         * The option is a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder useJDBC4ColumnNameAndLabelSemantics(
                boolean useJDBC4ColumnNameAndLabelSemantics) {
            setProperty("useJDBC4ColumnNameAndLabelSemantics", useJDBC4ColumnNameAndLabelSemantics);
            return this;
        }
        /**
         * Sets whether to use JDBC 4 or JDBC 3.0 or older semantic when
         * retrieving column name. JDBC 4.0 uses columnLabel to get the column
         * name where as JDBC 3.0 uses both columnName or columnLabel.
         * Unfortunately JDBC drivers behave differently so you can use this
         * option to work out issues around your JDBC driver if you get problem
         * using this component This option is default true.
         * The option will be converted to a <code>boolean</code> type.
         * @group producer
         */
        default JdbcEndpointBuilder useJDBC4ColumnNameAndLabelSemantics(
                String useJDBC4ColumnNameAndLabelSemantics) {
            setProperty("useJDBC4ColumnNameAndLabelSemantics", useJDBC4ColumnNameAndLabelSemantics);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the JDBC component.
     */
    public interface AdvancedJdbcEndpointBuilder
            extends
                EndpointProducerBuilder {
        default JdbcEndpointBuilder basic() {
            return (JdbcEndpointBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedJdbcEndpointBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            setProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * The option will be converted to a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedJdbcEndpointBuilder basicPropertyBinding(
                String basicPropertyBinding) {
            setProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * To use a custom org.apache.camel.component.jdbc.BeanRowMapper when
         * using outputClass. The default implementation will lower case the row
         * names and skip underscores, and dashes. For example CUST_ID is mapped
         * as custId.
         * The option is a
         * <code>org.apache.camel.component.jdbc.BeanRowMapper</code> type.
         * @group advanced
         */
        default AdvancedJdbcEndpointBuilder beanRowMapper(Object beanRowMapper) {
            setProperty("beanRowMapper", beanRowMapper);
            return this;
        }
        /**
         * To use a custom org.apache.camel.component.jdbc.BeanRowMapper when
         * using outputClass. The default implementation will lower case the row
         * names and skip underscores, and dashes. For example CUST_ID is mapped
         * as custId.
         * The option will be converted to a
         * <code>org.apache.camel.component.jdbc.BeanRowMapper</code> type.
         * @group advanced
         */
        default AdvancedJdbcEndpointBuilder beanRowMapper(String beanRowMapper) {
            setProperty("beanRowMapper", beanRowMapper);
            return this;
        }
        /**
         * Allows to plugin to use a custom
         * org.apache.camel.component.jdbc.JdbcPrepareStatementStrategy to
         * control preparation of the query and prepared statement.
         * The option is a
         * <code>org.apache.camel.component.jdbc.JdbcPrepareStatementStrategy</code> type.
         * @group advanced
         */
        default AdvancedJdbcEndpointBuilder prepareStatementStrategy(
                Object prepareStatementStrategy) {
            setProperty("prepareStatementStrategy", prepareStatementStrategy);
            return this;
        }
        /**
         * Allows to plugin to use a custom
         * org.apache.camel.component.jdbc.JdbcPrepareStatementStrategy to
         * control preparation of the query and prepared statement.
         * The option will be converted to a
         * <code>org.apache.camel.component.jdbc.JdbcPrepareStatementStrategy</code> type.
         * @group advanced
         */
        default AdvancedJdbcEndpointBuilder prepareStatementStrategy(
                String prepareStatementStrategy) {
            setProperty("prepareStatementStrategy", prepareStatementStrategy);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * The option is a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedJdbcEndpointBuilder synchronous(boolean synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * The option will be converted to a <code>boolean</code> type.
         * @group advanced
         */
        default AdvancedJdbcEndpointBuilder synchronous(String synchronous) {
            setProperty("synchronous", synchronous);
            return this;
        }
    }

    /**
     * Proxy enum for
     * <code>org.apache.camel.component.jdbc.JdbcOutputType</code> enum.
     */
    enum JdbcOutputType {
        SelectOne,
SelectList,
StreamList;
    }
    /**
     * The jdbc component enables you to access databases through JDBC, where
     * SQL queries are sent in the message body. Creates a builder to build
     * endpoints for the JDBC component.
     */
    default JdbcEndpointBuilder jdbc(String path) {
        class JdbcEndpointBuilderImpl extends AbstractEndpointBuilder implements JdbcEndpointBuilder, AdvancedJdbcEndpointBuilder {
            public JdbcEndpointBuilderImpl(String path) {
                super("jdbc", path);
            }
        }
        return new JdbcEndpointBuilderImpl(path);
    }
}