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
import org.openxrd.xrd.core.URI;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.URIImpl}.
 */
public class URITest extends BaseXRDObjectProviderTestCase {

    /** Expected URI value. */
    protected String expectedValue;

    /** Constructor. */
    public URITest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/URI.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedValue = "http://example.com/";
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        URI uri = (URI) unmarshallElement(singleElementFile);

        String value = uri.getValue();
        assertEquals("URI value was " + value + ", expected " + expectedValue, expectedValue, value);
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        URI uri = (URI) buildXMLObject(URI.DEFAULT_ELEMENT_NAME);

        uri.setValue(expectedValue);
        assertEquals(expectedDOM, uri);
    }

}