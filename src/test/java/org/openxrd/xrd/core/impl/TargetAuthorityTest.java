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
import org.openxrd.xrd.core.TargetAuthority;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.TargetAuthorityImpl}.
 */
public class TargetAuthorityTest extends BaseXRDObjectProviderTestCase {

    /** Expected target authority value. */
    protected String expectedValue;

    /** Constructor. */
    public TargetAuthorityTest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/TargetAuthority.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedValue = "example.com";
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        TargetAuthority targetAuthority = (TargetAuthority) unmarshallElement(singleElementFile);

        String value = targetAuthority.getValue();
        assertEquals("TargetAuthority value was " + value + ", expected " + expectedValue, expectedValue, value);
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        QName qname = new QName(XRDConstants.XRD_NS, TargetAuthority.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
        TargetAuthority targetAuthority = (TargetAuthority) buildXMLObject(qname);

        targetAuthority.setValue(expectedValue);
        assertEquals(expectedDOM, targetAuthority);
    }
    
}