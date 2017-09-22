/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.core.stream.output.sink;

import org.wso2.siddhi.core.config.SiddhiAppContext;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

/**
 * SinkHandler is an optional interface before {@link SinkMapper}.
 * It will do optional processing to the events before sending the events to the desired mapper
 */
public abstract class SinkHandler {

    private Sink sink;
    private String sinkElementId;
    private StreamDefinition streamDefinition;
    private SiddhiAppContext siddhiAppContext;
    private SinkMapper sinkMapper;

    public final void init(Sink sink, String sinkElementId, StreamDefinition streamDefinition,
                           SiddhiAppContext siddhiAppContext, SinkMapper sinkMapper) {
        this.sink = sink;
        this.sinkElementId = sinkElementId;
        this.streamDefinition = streamDefinition;
        this.siddhiAppContext = siddhiAppContext;
        this.sinkMapper = sinkMapper;
    }

    public abstract Event handle(Event event);

    public abstract Event[] handle(Event[] events);

    public Sink getSink() {
        return sink;
    }

    public String getSinkElementId() {
        return sinkElementId;
    }

    public StreamDefinition getStreamDefinition() {
        return streamDefinition;
    }

    public SiddhiAppContext getSiddhiAppContext() {
        return siddhiAppContext;
    }

    public SinkMapper getSinkMapper() {
        return sinkMapper;
    }
}
