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

import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.openxrd.common.BaseXRDObjectProviderTestCase;
import org.openxrd.common.XRDConstants;
import org.openxrd.xrd.core.Expires;

/**
 * Test case for creating, marshalling, and unmarshalling {@link org.openxrd.xrd.core.impl.ExpiresImpl}.
 */
public class ExpiresTest extends BaseXRDObjectProviderTestCase {

    /** Expected expires value. */
    protected DateTime expectedValue;

    /** Constructor. */
    public ExpiresTest() {
        singleElementFile = "/data/org/openxrd/xrd/core/impl/Expires.xml";
    }

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedValue = new DateTime(2005, 1, 31, 12, 0, 0, 0, ISOChronology.getInstanceUTC());
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        Expires expires = (Expires) unmarshallElement(singleElementFile);

        DateTime value = expires.getValue();
        assertEquals("Expires value was " + value + ", expected " + expectedValue, expectedValue, value);
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        QName qname = new QName(XRDConstants.XRD_NS, Expires.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
        Expires expires = (Expires) buildXMLObject(qname);

        expires.setValue(expectedValue);
        assertEquals(expectedDOM, expires);
    }
    
}