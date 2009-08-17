/*
 * Copyright 2009 University Corporation for Advanced Internet Development, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openxrd.xrd.core.impl;

import javax.xml.namespace.QName;

import org.openxrd.common.BaseXRDObjectProviderTestCase;
import org.openxrd.common.xml.XRDConstants;
import org.openxrd.xrd.core.Type;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.TypeImpl}.
 */
public class TypeTest extends BaseXRDObjectProviderTestCase {

    /** Expected type value. */
    protected String expectedValue;

    /** Expected required value. */
    protected Boolean expectedRequired;

    /** Constructor. */
    public TypeTest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/Type.xml";
        singleElementOptionalAttributesFile = "/data/org/openxrd/xrd/core/impl/TypeOptionalAttributes.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedValue = "http://type.example.com/";
        expectedRequired = Boolean.TRUE;
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        Type type = (Type) unmarshallElement(singleElementFile);

        String value = type.getValue();
        assertEquals("Type value was " + value + ", expected " + expectedValue, expectedValue, value);
    }

    /** {@inheritDoc} */
    public void testSingleElementOptionalAttributesUnmarshall() {
        Type type = (Type) unmarshallElement(singleElementOptionalAttributesFile);

        String value = type.getValue();
        assertEquals("Type value was " + value + ", expected " + expectedValue, expectedValue, value);

        Boolean required = type.isRequired();
        assertEquals("Required value was " + required.toString() + ", expected " + expectedRequired.toString(),
                expectedRequired, required);
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        QName qname = new QName(XRDConstants.XRD_NS, Type.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
        Type type = (Type) buildXMLObject(qname);

        type.setValue(expectedValue);
        assertEquals(expectedDOM, type);
    }

    /** {@inheritDoc} */
    public void testSingleElementOptionalAttributesMarshall() {
        QName qname = new QName(XRDConstants.XRD_NS, Type.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
        Type type = (Type) buildXMLObject(qname);

        type.setValue(expectedValue);
        type.setRequired(expectedRequired);
        assertEquals(expectedOptionalAttributesDOM, type);
    }

}