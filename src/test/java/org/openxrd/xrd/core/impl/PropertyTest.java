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

import org.openxrd.common.BaseXRDObjectProviderTestCase;
import org.openxrd.xrd.core.Property;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.PropertyImpl}.
 */
public class PropertyTest extends BaseXRDObjectProviderTestCase {

    /** Expected property value. */
    protected String expectedValue;

    /** Expected property type. */
    protected String expectedType;

    /** Constructor. */
    public PropertyTest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/Property.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedValue = "123";
        expectedType = "http://type.example.com/";
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        Property property = (Property) unmarshallElement(singleElementFile);

        String value = property.getValue();
        assertEquals("Type value was " + value + ", expected " + expectedValue, expectedValue, value);

        String type = property.getType();
        assertEquals("Required value was " + type.toString() + ", expected " + expectedType.toString(), expectedType,
                type);
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        Property property = (Property) buildXMLObject(Property.DEFAULT_ELEMENT_NAME);

        property.setValue(expectedValue);
        property.setType(expectedType);
        assertEquals(expectedDOM, property);
    }

}