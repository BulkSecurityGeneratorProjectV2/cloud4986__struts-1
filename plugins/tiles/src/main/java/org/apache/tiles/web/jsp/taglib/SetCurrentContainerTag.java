/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tiles.web.jsp.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.tiles.autotag.core.runtime.AutotagRuntime;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.jsp.autotag.JspAutotagRuntime;
import org.apache.tiles.template.SetCurrentContainerModel;

/**
 * Selects a container to be used as the "current" container.
 */
public class SetCurrentContainerTag extends SimpleTagSupport {

    /**
     * The template model.
     */
    private SetCurrentContainerModel model = new SetCurrentContainerModel();

    /**
     * The key of the container to be used as "current". If null, the default one
     * will be used.
     */
    private String containerKey;

    /**
     * Getter for containerKey property.
     *
     * @return The key of the container to be used as "current". If null, the
     *         default one will be used.
     */
    public String getContainerKey() {
        return containerKey;
    }

    /**
     * Setter for containerKey property.
     *
     * @param containerKey The key of the container to be used as "current". If
     *                     null, the default one will be used.
     */
    public void setContainerKey(String containerKey) {
        this.containerKey = containerKey;
    }

    /** {@inheritDoc} */
    @Override
    public void doTag() throws JspException, IOException {
        AutotagRuntime<Request> runtime = new JspAutotagRuntime();
        if (runtime instanceof SimpleTagSupport) {
            SimpleTagSupport tag = (SimpleTagSupport) runtime;
            tag.setJspContext(getJspContext());
            tag.setJspBody(getJspBody());
            tag.setParent(getParent());
            tag.doTag();
        }
        Request request = runtime.createRequest();
        model.execute(containerKey, request);
    }
}
