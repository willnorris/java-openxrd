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
import org.openxrd.common.XRDConstants;
import org.openxrd.xrd.core.MediaType;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.MediaTypeImpl}.
 */
public class MediaTypeTest extends BaseXRDObjectProviderTestCase {

    /** Expected media type value. */
    protected String expectedValue;

    /** Constructor. */
    public MediaTypeTest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/MediaType.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedValue = "image/jpeg";
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        MediaType mediaType = (MediaType) unmarshallElement(singleElementFile);

        String value = mediaType.getValue();
        assertEquals("MediaType value was " + value + ", expected " + expectedValue, expectedValue, value);
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        MediaType mediaType = (MediaType) buildXMLObject(MediaType.DEFAULT_ELEMENT_NAME);

        mediaType.setValue(expectedValue);
        assertEquals(expectedDOM, mediaType);
    }

}