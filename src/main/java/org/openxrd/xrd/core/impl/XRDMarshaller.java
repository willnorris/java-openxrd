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

import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.MarshallingException;
import org.openxrd.xrd.common.impl.AbstractXRDObjectMarshaller;
import org.openxrd.xrd.core.XRD;
import org.w3c.dom.Element;

/**
 * A thread-safe marshaller for {@link XRD}.
 */
public class XRDMarshaller extends AbstractXRDObjectMarshaller {

    /** {@inheritDoc} */
    protected void marshallAttributes(XMLObject xmlObject, Element domElement) throws MarshallingException {
        XRD xrd = (XRD) xmlObject;

        if (xrd.getID() != null) {
            domElement.setAttributeNS(XRD.ID_ATTRIB_NAME.getNamespaceURI(), XRD.ID_ATTRIB_NAME.getPrefix() + ":"
                    + XRD.ID_ATTRIB_NAME.getLocalPart(), xrd.getID());
        }

        super.marshallAttributes(xmlObject, domElement);
    }

}