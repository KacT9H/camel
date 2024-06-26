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
package org.apache.camel.component.knative.spi;

import org.apache.camel.cloudevents.CloudEvent;

public final class KnativeTransportConfiguration {

    private final CloudEvent cloudEvent;
    private final boolean removeCloudEventHeadersInReply;
    private final boolean reply;

    public KnativeTransportConfiguration(CloudEvent cloudEvent, boolean removeCloudEventHeadersInReply, boolean reply) {
        this.cloudEvent = cloudEvent;
        this.removeCloudEventHeadersInReply = removeCloudEventHeadersInReply;
        this.reply = reply;
    }

    public CloudEvent getCloudEvent() {
        return cloudEvent;
    }

    public boolean isRemoveCloudEventHeadersInReply() {
        return removeCloudEventHeadersInReply;
    }

    public boolean isReply() {
        return reply;
    }
}
