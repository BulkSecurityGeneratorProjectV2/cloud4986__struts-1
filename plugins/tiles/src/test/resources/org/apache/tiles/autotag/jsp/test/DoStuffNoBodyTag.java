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
 /*
 * This file was automatically generated.
 */
package org.apache.tiles.autotag.jsp.test;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.tiles.autotag.core.runtime.AutotagRuntime;

/**
 * Documentation of the DoStuffNoBody class.
 */
public class DoStuffNoBodyTag extends SimpleTagSupport {

    /**
     * The template model.
     */
    private org.apache.tiles.autotag.template.DoStuffNoBodyTemplate model = new org.apache.tiles.autotag.template.DoStuffNoBodyTemplate();

    /**
     * Parameter one.
     */
    private java.lang.Double one;

    /**
     * Parameter two.
     */
    private float two;

    /**
     * Parameter three.
     */
    private java.util.Date three;

    /**
     * Getter for one property.
     *
     * @return
     * Parameter one.
     */
    public java.lang.Double getOne() {
        return one;
    }

    /**
     * Setter for one property.
     *
     * @param one
     * Parameter one.
     */
    public void setOne(java.lang.Double one) {
        this.one = one;
    }

    /**
     * Getter for two property.
     *
     * @return
     * Parameter two.
     */
    public float getTwo() {
        return two;
    }

    /**
     * Setter for two property.
     *
     * @param two
     * Parameter two.
     */
    public void setTwo(float two) {
        this.two = two;
    }

    /**
     * Getter for three property.
     *
     * @return
     * Parameter three.
     */
    public java.util.Date getThree() {
        return three;
    }

    /**
     * Setter for three property.
     *
     * @param three
     * Parameter three.
     */
    public void setThree(java.util.Date three) {
        this.three = three;
    }

    @Override
    public void doTag() throws JspException, IOException {
        AutotagRuntime<org.apache.tiles.autotag.jsp.test.Request> runtime = new org.apache.tiles.autotag.jsp.test.Runtime();
        if (runtime instanceof SimpleTagSupport) {
            SimpleTagSupport tag = (SimpleTagSupport) runtime;
            tag.setJspContext(getJspContext());
            tag.setJspBody(getJspBody());
            tag.setParent(getParent());
            tag.doTag();
        }
        org.apache.tiles.autotag.jsp.test.Request request = runtime.createRequest();
        model.execute(
            one,
            two,
            three,
            request
        );
    }
}
