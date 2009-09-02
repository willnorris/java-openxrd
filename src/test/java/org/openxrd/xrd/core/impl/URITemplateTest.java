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
import org.openxrd.xrd.core.URITemplate;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.URITemplateImpl}.
 */
public class URITemplateTest extends BaseXRDObjectProviderTestCase {

    /** Expected URI template value. */
    protected String expectedValue;

    /** Constructor. */
    public URITemplateTest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/URITemplate.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedValue = "{uri};about";
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        URITemplate uriTemplate = (URITemplate) unmarshallElement(singleElementFile);

        String value = uriTemplate.getValue();
        assertEquals("URITemplate value was " + value + ", expected " + expectedValue, expectedValue, value);
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        URITemplate uriTemplate = (URITemplate) buildXMLObject(URITemplate.DEFAULT_ELEMENT_NAME);

        uriTemplate.setValue(expectedValue);
        assertEquals(expectedDOM, uriTemplate);
    }

}