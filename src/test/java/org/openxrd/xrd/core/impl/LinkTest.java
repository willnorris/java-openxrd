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

import org.opensaml.xml.signature.KeyInfo;
import org.openxrd.common.BaseXRDObjectProviderTestCase;
import org.openxrd.xrd.core.Link;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.LinkImpl}.
 */
public class LinkTest extends BaseXRDObjectProviderTestCase {

    /** Expected rel value. */
    protected String expectedRel;

    /** Expected type value. */
    protected String expectedType;

    /** Expected href value. */
    protected String expectedHref;

    /** Expected template value. */
    protected String expectedTemplate;

    /** Count of KeyInfo sub-elements. */
    protected int keyInfoCount;

    /** Constructor. */
    public LinkTest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/Link.xml";
        childElementsFile = "/data/org/openxrd/xrd/core/impl/LinkChildElements.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedRel = "author";
        expectedType = "text/html";
        expectedHref = "http://www.example.com/";
        expectedTemplate = "http://www.example.com/author?uri={uri}";
        keyInfoCount = 2;
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        Link link = (Link) unmarshallElement(singleElementFile);

        String href = link.getHref();
        assertEquals("Type value was " + href.toString() + ", expected " + expectedHref.toString(), expectedHref, href);

        String rel = link.getRel();
        assertEquals("Type value was " + rel.toString() + ", expected " + expectedRel.toString(), expectedRel, rel);

        String template = link.getTemplate();
        assertEquals("Type value was " + template.toString() + ", expected " + expectedTemplate.toString(),
                expectedTemplate, template);

        String type = link.getType();
        assertEquals("Type value was " + type.toString() + ", expected " + expectedType.toString(), expectedType, type);
    }

    /** {@inheritDoc} */
    public void testChildElementsUnmarshall() {
        Link link = (Link) unmarshallElement(childElementsFile);

        assertEquals("KeyInfo count not as expected", keyInfoCount, link.getKeyInfos().size());
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        Link link = (Link) buildXMLObject(Link.DEFAULT_ELEMENT_NAME);

        link.setHref(expectedHref);
        link.setRel(expectedRel);
        link.setTemplate(expectedTemplate);
        link.setType(expectedType);

        assertEquals(expectedDOM, link);
    }

    /** {@inheritDoc} */
    public void testChildElementsMarshall() {
        Link link = (Link) buildXMLObject(Link.DEFAULT_ELEMENT_NAME);

        for (int i = 0; i < keyInfoCount; i++) {
            link.getKeyInfos().add((KeyInfo) buildXMLObject(KeyInfo.DEFAULT_ELEMENT_NAME));
        }

        assertEquals(expectedChildElementsDOM, link);
    }

}