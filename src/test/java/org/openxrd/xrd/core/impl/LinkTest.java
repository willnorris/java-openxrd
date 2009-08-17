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
import org.openxrd.xrd.core.Link;
import org.openxrd.xrd.core.MediaType;
import org.openxrd.xrd.core.Rel;
import org.openxrd.xrd.core.TargetAuthority;
import org.openxrd.xrd.core.URI;
import org.openxrd.xrd.core.URITemplate;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.LinkImpl}.
 */
public class LinkTest extends BaseXRDObjectProviderTestCase {

    /** Expected priority value. */
    protected Integer expectedPriority;

    /** Count of Rel sub-elements. */
    protected int relCount;

    /** Count of MediaType sub-elements. */
    protected int mediaTypeCount;

    /** Count of URI sub-elements. */
    protected int uriCount;

    /** Count of URITemplate sub-elements. */
    protected int uriTemplateCount;

    /** Constructor. */
    public LinkTest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/Link.xml";
        childElementsFile = "/data/org/openxrd/xrd/core/impl/LinkChildElements.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedPriority = 42;
        relCount = 3;
        mediaTypeCount = 2;
        uriCount = 3;
        uriTemplateCount = 2;
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        Link link = (Link) unmarshallElement(singleElementFile);

        Integer priority = link.getPriority();
        assertEquals("Priority value was " + priority + ", expected " + expectedPriority, expectedPriority, priority);
    }

    /** {@inheritDoc} */
    public void testChildElementsUnmarshall() {
        Link link = (Link) unmarshallElement(childElementsFile);

        assertEquals("Rel count not as expected", relCount, link.getRels().size());
        assertEquals("MediaType count not as expected", mediaTypeCount, link.getMediaTypes().size());
        assertEquals("URI count not as expected", uriCount, link.getURIs().size());
        assertEquals("URITemplate count not as expected", uriTemplateCount, link.getURITemplates().size());
        assertNotNull("TargetAuthority element not present", link.getTargetAuthority());
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        QName qname = new QName(XRDConstants.XRD_NS, Link.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
        Link link = (Link) buildXMLObject(qname);

        link.setPriority(expectedPriority);
        assertEquals(expectedDOM, link);
    }

    /** {@inheritDoc} */
    public void testChildElementsMarshall() {
        QName qname = new QName(XRDConstants.XRD_NS, Link.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
        Link link = (Link) buildXMLObject(qname);

        QName relQName = new QName(XRDConstants.XRD_NS, Rel.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
        for (int i = 0; i < relCount; i++) {
            link.getRels().add((Rel) buildXMLObject(relQName));
        }

        QName mediaTypeQName = new QName(XRDConstants.XRD_NS, MediaType.DEFAULT_ELEMENT_LOCAL_NAME,
                XRDConstants.XRD_PREFIX);
        for (int i = 0; i < mediaTypeCount; i++) {
            link.getMediaTypes().add((MediaType) buildXMLObject(mediaTypeQName));
        }

        QName uriQName = new QName(XRDConstants.XRD_NS, URI.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
        for (int i = 0; i < uriCount; i++) {
            link.getURIs().add((URI) buildXMLObject(uriQName));
        }

        QName uriTemplateQName = new QName(XRDConstants.XRD_NS, URITemplate.DEFAULT_ELEMENT_LOCAL_NAME,
                XRDConstants.XRD_PREFIX);
        for (int i = 0; i < uriTemplateCount; i++) {
            link.getURITemplates().add((URITemplate) buildXMLObject(uriTemplateQName));
        }

        QName targetAuthorityQName = new QName(XRDConstants.XRDTRUST_NS, TargetAuthority.DEFAULT_ELEMENT_LOCAL_NAME,
                XRDConstants.XRDTRUST_PREFIX);
        link.setTargetAuthority((TargetAuthority) buildXMLObject(targetAuthorityQName));

        assertEquals(expectedChildElementsDOM, link);
    }

}