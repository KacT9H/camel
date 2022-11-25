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
package org.apache.camel.builder.component.dsl;

import javax.annotation.processing.Generated;
import org.apache.camel.Component;
import org.apache.camel.builder.component.AbstractComponentBuilder;
import org.apache.camel.builder.component.ComponentBuilder;
import org.apache.camel.component.google.sheets.stream.GoogleSheetsStreamComponent;

/**
 * Poll for changes in Google Sheets.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.ComponentDslMojo")
public interface GoogleSheetsStreamComponentBuilderFactory {

    /**
     * Google Sheets Stream (camel-google-sheets)
     * Poll for changes in Google Sheets.
     * 
     * Category: cloud,sheets
     * Since: 2.23
     * Maven coordinates: org.apache.camel:camel-google-sheets
     * 
     * @return the dsl builder
     */
    static GoogleSheetsStreamComponentBuilder googleSheetsStream() {
        return new GoogleSheetsStreamComponentBuilderImpl();
    }

    /**
     * Builder for the Google Sheets Stream component.
     */
    interface GoogleSheetsStreamComponentBuilder
            extends
                ComponentBuilder<GoogleSheetsStreamComponent> {
        /**
         * Google sheets application name. Example would be
         * camel-google-sheets/1.0.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: consumer
         * 
         * @param applicationName the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder applicationName(
                java.lang.String applicationName) {
            doSetProperty("applicationName", applicationName);
            return this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: consumer
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * Client ID of the sheets application.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: consumer
         * 
         * @param clientId the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder clientId(
                java.lang.String clientId) {
            doSetProperty("clientId", clientId);
            return this;
        }
        /**
         * To use the shared configuration.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.google.sheets.stream.GoogleSheetsStreamConfiguration&lt;/code&gt; type.
         * 
         * Group: consumer
         * 
         * @param configuration the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder configuration(
                org.apache.camel.component.google.sheets.stream.GoogleSheetsStreamConfiguration configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * Delegate for wide-domain service account.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: consumer
         * 
         * @param delegate the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder delegate(
                java.lang.String delegate) {
            doSetProperty("delegate", delegate);
            return this;
        }
        /**
         * True if grid data should be returned.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: consumer
         * 
         * @param includeGridData the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder includeGridData(
                boolean includeGridData) {
            doSetProperty("includeGridData", includeGridData);
            return this;
        }
        /**
         * Specifies the major dimension that results should use..
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Default: ROWS
         * Group: consumer
         * 
         * @param majorDimension the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder majorDimension(
                java.lang.String majorDimension) {
            doSetProperty("majorDimension", majorDimension);
            return this;
        }
        /**
         * Specify the maximum number of returned results. This will limit the
         * number of rows in a returned value range data set or the number of
         * returned value ranges in a batch request.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Group: consumer
         * 
         * @param maxResults the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder maxResults(int maxResults) {
            doSetProperty("maxResults", maxResults);
            return this;
        }
        /**
         * Specifies the range of rows and columns in a sheet to get data from.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: consumer
         * 
         * @param range the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder range(java.lang.String range) {
            doSetProperty("range", range);
            return this;
        }
        /**
         * Specifies the level of permissions you want a sheets application to
         * have to a user account. See
         * https://developers.google.com/identity/protocols/googlescopes for
         * more info.
         * 
         * The option is a:
         * &lt;code&gt;java.util.List&amp;lt;java.lang.String&amp;gt;&lt;/code&gt; type.
         * 
         * Group: consumer
         * 
         * @param scopes the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder scopes(
                java.util.List<java.lang.String> scopes) {
            doSetProperty("scopes", scopes);
            return this;
        }
        /**
         * True if value range result should be split into rows or columns to
         * process each of them individually. When true each row or column is
         * represented with a separate exchange in batch processing. Otherwise
         * value range object is used as exchange junk size.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: consumer
         * 
         * @param splitResults the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder splitResults(
                boolean splitResults) {
            doSetProperty("splitResults", splitResults);
            return this;
        }
        /**
         * Determines how values should be rendered in the output.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Default: FORMATTED_VALUE
         * Group: consumer
         * 
         * @param valueRenderOption the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder valueRenderOption(
                java.lang.String valueRenderOption) {
            doSetProperty("valueRenderOption", valueRenderOption);
            return this;
        }
        /**
         * Whether autowiring is enabled. This is used for automatic autowiring
         * options (the option must be marked as autowired) by looking up in the
         * registry to find if there is a single instance of matching type,
         * which then gets configured on the component. This can be used for
         * automatic configuring JDBC data sources, JMS connection factories,
         * AWS Clients, etc.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: advanced
         * 
         * @param autowiredEnabled the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder autowiredEnabled(
                boolean autowiredEnabled) {
            doSetProperty("autowiredEnabled", autowiredEnabled);
            return this;
        }
        /**
         * To use the GoogleSheetsClientFactory as factory for creating the
         * client. Will by default use BatchGoogleSheetsClientFactory.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.google.sheets.GoogleSheetsClientFactory&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param clientFactory the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder clientFactory(
                org.apache.camel.component.google.sheets.GoogleSheetsClientFactory clientFactory) {
            doSetProperty("clientFactory", clientFactory);
            return this;
        }
        /**
         * OAuth 2 access token. This typically expires after an hour so
         * refreshToken is recommended for long term usage.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param accessToken the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder accessToken(
                java.lang.String accessToken) {
            doSetProperty("accessToken", accessToken);
            return this;
        }
        /**
         * Client secret of the sheets application.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param clientSecret the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder clientSecret(
                java.lang.String clientSecret) {
            doSetProperty("clientSecret", clientSecret);
            return this;
        }
        /**
         * OAuth 2 refresh token. Using this, the Google Calendar component can
         * obtain a new accessToken whenever the current one expires - a
         * necessity if the application is long-lived.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param refreshToken the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder refreshToken(
                java.lang.String refreshToken) {
            doSetProperty("refreshToken", refreshToken);
            return this;
        }
        /**
         * Sets .json file with credentials for Service account.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param serviceAccountKey the value to set
         * @return the dsl builder
         */
        default GoogleSheetsStreamComponentBuilder serviceAccountKey(
                java.lang.String serviceAccountKey) {
            doSetProperty("serviceAccountKey", serviceAccountKey);
            return this;
        }
    }

    class GoogleSheetsStreamComponentBuilderImpl
            extends
                AbstractComponentBuilder<GoogleSheetsStreamComponent>
            implements
                GoogleSheetsStreamComponentBuilder {
        @Override
        protected GoogleSheetsStreamComponent buildConcreteComponent() {
            return new GoogleSheetsStreamComponent();
        }
        private org.apache.camel.component.google.sheets.stream.GoogleSheetsStreamConfiguration getOrCreateConfiguration(
                org.apache.camel.component.google.sheets.stream.GoogleSheetsStreamComponent component) {
            if (component.getConfiguration() == null) {
                component.setConfiguration(new org.apache.camel.component.google.sheets.stream.GoogleSheetsStreamConfiguration());
            }
            return component.getConfiguration();
        }
        @Override
        protected boolean setPropertyOnComponent(
                Component component,
                String name,
                Object value) {
            switch (name) {
            case "applicationName": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setApplicationName((java.lang.String) value); return true;
            case "bridgeErrorHandler": ((GoogleSheetsStreamComponent) component).setBridgeErrorHandler((boolean) value); return true;
            case "clientId": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setClientId((java.lang.String) value); return true;
            case "configuration": ((GoogleSheetsStreamComponent) component).setConfiguration((org.apache.camel.component.google.sheets.stream.GoogleSheetsStreamConfiguration) value); return true;
            case "delegate": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setDelegate((java.lang.String) value); return true;
            case "includeGridData": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setIncludeGridData((boolean) value); return true;
            case "majorDimension": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setMajorDimension((java.lang.String) value); return true;
            case "maxResults": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setMaxResults((int) value); return true;
            case "range": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setRange((java.lang.String) value); return true;
            case "scopes": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setScopes((java.util.List) value); return true;
            case "splitResults": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setSplitResults((boolean) value); return true;
            case "valueRenderOption": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setValueRenderOption((java.lang.String) value); return true;
            case "autowiredEnabled": ((GoogleSheetsStreamComponent) component).setAutowiredEnabled((boolean) value); return true;
            case "clientFactory": ((GoogleSheetsStreamComponent) component).setClientFactory((org.apache.camel.component.google.sheets.GoogleSheetsClientFactory) value); return true;
            case "accessToken": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setAccessToken((java.lang.String) value); return true;
            case "clientSecret": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setClientSecret((java.lang.String) value); return true;
            case "refreshToken": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setRefreshToken((java.lang.String) value); return true;
            case "serviceAccountKey": getOrCreateConfiguration((GoogleSheetsStreamComponent) component).setServiceAccountKey((java.lang.String) value); return true;
            default: return false;
            }
        }
    }
}