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
import org.apache.tiles.template.PutAttributeModel;
import org.apache.tiles.autotag.core.runtime.AutotagRuntime;

/**
 * <p>
 * Put an attribute in enclosing attribute container tag.
 * </p>
 * <p>
 * Enclosing attribute container tag can be :
 * <ul>
 * <li>&lt;initContainer&gt;</li>
 * <li>&lt;definition&gt;</li>
 * <li>&lt;insertAttribute&gt;</li>
 * <li>&lt;insertDefinition&gt;</li>
 * <li>&lt;putListAttribute&gt;</li>
 * </ul>
 * (or any other tag which implements the PutAttributeTagParent interface.
 * Exception is thrown if no appropriate tag can be found.
 * </p>
 * <p>
 * Put tag can have following atributes :
 * <ul>
 * <li>name : Name of the attribute</li>
 * <li>value : value to put as attribute</li>
 * <li>type : value type. Possible type are : string (value is used as direct
 * string), template (value is used as a page url to insert), definition (value
 * is used as a definition name to insert), object (value is used as it is)</li>
 * <li>role : Role to check when 'insertAttribute' will be called.</li>
 * </ul>
 * </p>
 * <p>
 * Value can also come from tag body. Tag body is taken into account only if
 * value is not set by one of the tag attributes. In this case Attribute type is
 * "string", unless tag body define another type.
 * </p>
 */
public class PutAttributeTag extends SimpleTagSupport {

    /**
     * The template model.
     */
    private PutAttributeModel model = new org.apache.tiles.template.PutAttributeModel();

    /**
     * The name of the attribute to put.
     */
    private String name;

    /**
     * The value of the attribute. Use this parameter, or expression, or body.
     */
    private Object value;

    /**
     * The expression to calculate the value from. Use this parameter, or value, or
     * body.
     */
    private String expression;

    /**
     * A comma-separated list of roles. If present, the attribute will be rendered
     * only if the current user belongs to one of the roles.
     */
    private String role;

    /**
     * The type (renderer) of the attribute.
     */
    private String type;

    /**
     * If true the attribute will be cascaded to all nested attributes.
     */
    private boolean cascade;

    /**
     * Getter for name property.
     *
     * @return The name of the attribute to put.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name property.
     *
     * @param name The name of the attribute to put.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for value property.
     *
     * @return The value of the attribute. Use this parameter, or expression, or
     *         body.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Setter for value property.
     *
     * @param value The value of the attribute. Use this parameter, or expression,
     *              or body.
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Getter for expression property.
     *
     * @return The expression to calculate the value from. Use this parameter, or
     *         value, or body.
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Setter for expression property.
     *
     * @param expression The expression to calculate the value from. Use this
     *                   parameter, or value, or body.
     */
    public void setExpression(String expression) {
        this.expression = expression;
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
     * Getter for type property.
     *
     * @return The type (renderer) of the attribute.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type property.
     *
     * @param type The type (renderer) of the attribute.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for cascade property.
     *
     * @return If true the attribute will be cascaded to all nested attributes.
     */
    public boolean isCascade() {
        return cascade;
    }

    /**
     * Setter for cascade property.
     *
     * @param cascade If true the attribute will be cascaded to all nested
     *                attributes.
     */
    public void setCascade(boolean cascade) {
        this.cascade = cascade;
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
        model.execute(name, value, expression, role, type, cascade, request, modelBody);
    }
}
