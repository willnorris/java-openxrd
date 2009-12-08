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
import org.openxrd.xrd.core.Title;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.TitleImpl}.
 */
public class TitleTest extends BaseXRDObjectProviderTestCase {

    /** Expected title value. */
    protected String expectedValue;

    /** Expected title language. */
    protected String expectedLanguage;

    /** Constructor. */
    public TitleTest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/Title.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedValue = "Article author";
        expectedLanguage = "en";
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        Title property = (Title) unmarshallElement(singleElementFile);

        String value = property.getValue();
        assertEquals("Property value was " + value + ", expected " + expectedValue, expectedValue, value);

        String language = property.getLanguage();
        assertEquals("Language value was " + language.toString() + ", expected " + expectedLanguage.toString(),
                expectedLanguage, language);
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        Title title = (Title) buildXMLObject(Title.DEFAULT_ELEMENT_NAME);

        title.setValue(expectedValue);
        title.setLanguage(expectedLanguage);
        assertEquals(expectedDOM, title);
    }

}