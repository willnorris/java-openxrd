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
import org.openxrd.xrd.core.XRD;
import org.openxrd.xrd.core.XRDSequence;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.XRDImpl}.
 */
public class XRDSequenceTest extends BaseXRDObjectProviderTestCase {

    /** Expected ref value. */
    protected String expectedRef;

    /** Count of XRD sub-elements. */
    protected int xrdCount;

    /** Constructor. */
    public XRDSequenceTest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/XRDSequence.xml";
        childElementsFile = "/data/org/openxrd/xrd/core/impl/XRDSequenceChildElements.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedRef = "http://www.example.com/";
        xrdCount = 3;
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        XRDSequence xrds = (XRDSequence) unmarshallElement(singleElementFile);

        String ref = xrds.getRef();
        assertEquals("Ref was " + ref + ", expected " + expectedRef, expectedRef, ref);
    }

    /** {@inheritDoc} */
    public void testChildElementsUnmarshall() {
        XRDSequence xrds = (XRDSequence) unmarshallElement(childElementsFile);

        assertEquals("XRD count not as expected", xrdCount, xrds.getXRDs().size());
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        XRDSequence xrds = (XRDSequence) buildXMLObject(XRDSequence.DEFAULT_ELEMENT_NAME);

        xrds.setRef(expectedRef);
        assertEquals(expectedDOM, xrds);
    }

    /** {@inheritDoc} */
    public void testChildElementsMarshall() {
        XRDSequence xrds = (XRDSequence) buildXMLObject(XRDSequence.DEFAULT_ELEMENT_NAME);

        for (int i = 0; i < xrdCount; i++) {
            xrds.getXRDs().add((XRD) buildXMLObject(XRD.DEFAULT_ELEMENT_NAME));
        }

        assertEquals(expectedChildElementsDOM, xrds);
    }

}