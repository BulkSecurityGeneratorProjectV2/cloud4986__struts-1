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

import org.apache.tiles.autotag.core.runtime.ModelBody;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.jsp.autotag.JspAutotagRuntime;
import org.apache.tiles.template.GetAsStringModel;
import org.apache.tiles.api.Attribute;
import org.apache.tiles.autotag.core.runtime.AutotagRuntime;

/**
 * <p>
 * Render the value of the specified template attribute to the current Writer
 * </p>
 * 
 * <p>
 * Retrieve the value of the specified template attribute property, and render
 * it to the current Writer as a String. The usual toString() conversions is
 * applied on found value.
 * </p>
 */
public class GetAsStringTag extends SimpleTagSupport {

    /**
     * The template model.
     */
    private GetAsStringModel model = new GetAsStringModel();

    /**
     * If true, if an exception happens during rendering, of if the attribute is
     * null, the problem will be ignored.
     */
    private boolean ignore;

    /**
     * The preparer to invoke before rendering the attribute.
     */
    private String preparer;

    /**
     * A comma-separated list of roles. If present, the attribute will be rendered
     * only if the current user belongs to one of the roles.
     */
    private String role;

    /**
     * The default value of the attribute. To use only if the attribute was not
     * computed.
     */
    private Object defaultValue;

    /**
     * The default comma-separated list of roles. To use only if the attribute was
     * not computed.
     */
    private String defaultValueRole;

    /**
     * The default type of the attribute. To use only if the attribute was not
     * computed.
     */
    private String defaultValueType;

    /**
     * The name of the attribute.
     */
    private String name;

    /**
     * The attribute to use immediately, if not null.
     */
    private Attribute value;

    /**
     * Getter for ignore property.
     *
     * @return If true, if an exception happens during rendering, of if the
     *         attribute is null, the problem will be ignored.
     */
    public boolean isIgnore() {
        return ignore;
    }

    /**
     * Setter for ignore property.
     *
     * @param ignore If true, if an exception happens during rendering, of if the
     *               attribute is null, the problem will be ignored.
     */
    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    /**
     * Getter for preparer property.
     *
     * @return The preparer to invoke before rendering the attribute.
     */
    public String getPreparer() {
        return preparer;
    }

    /**
     * Setter for preparer property.
     *
     * @param preparer The preparer to invoke before rendering the attribute.
     */
    public void setPreparer(String preparer) {
        this.preparer = preparer;
    }

    /**
     * Getter for role property.
     *
     * @return A comma-separated list of roles. If present, the attribute will be
     *         rendered only if the current user belongs to one of the roles.
     */
    public String getRole() {
        return role;
    }

    /**
     * Setter for role property.
     *
     * @param role A comma-separated list of roles. If present, the attribute will
     *             be rendered only if the current user belongs to one of the roles.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Getter for defaultValue property.
     *
     * @return The default value of the attribute. To use only if the attribute was
     *         not computed.
     */
    public Object getDefaultValue() {
        return defaultValue;
    }

    /**
     * Setter for defaultValue property.
     *
     * @param defaultValue The default value of the attribute. To use only if the
     *                     attribute was not computed.
     */
    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Getter for defaultValueRole property.
     *
     * @return The default comma-separated list of roles. To use only if the
     *         attribute was not computed.
     */
    public String getDefaultValueRole() {
        return defaultValueRole;
    }

    /**
     * Setter for defaultValueRole property.
     *
     * @param defaultValueRole The default comma-separated list of roles. To use
     *                         only if the attribute was not computed.
     */
    public void setDefaultValueRole(String defaultValueRole) {
        this.defaultValueRole = defaultValueRole;
    }

    /**
     * Getter for defaultValueType property.
     *
     * @return The default type of the attribute. To use only if the attribute was
     *         not computed.
     */
    public String getDefaultValueType() {
        return defaultValueType;
    }

    /**
     * Setter for defaultValueType property.
     *
     * @param defaultValueType The default type of the attribute. To use only if the
     *                         attribute was not computed.
     */
    public void setDefaultValueType(String defaultValueType) {
        this.defaultValueType = defaultValueType;
    }

    /**
     * Getter for name property.
     *
     * @return The name of the attribute.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name property.
     *
     * @param name The name of the attribute.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for value property.
     *
     * @return The attribute to use immediately, if not null.
     */
    public Attribute getValue() {
        return value;
    }

    /**
     * Setter for value property.
     *
     * @param value The attribute to use immediately, if not null.
     */
    public void setValue(Attribute value) {
        this.value = value;
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
        ModelBody modelBody = runtime.createModelBody();
        model.execute(ignore, preparer, role, defaultValue, defaultValueRole, defaultValueType, name, value, request,
                modelBody);
    }
}
