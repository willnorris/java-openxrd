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
import org.opensaml.xml.io.UnmarshallingException;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.util.DatatypeHelper;
import org.openxrd.xrd.common.impl.AbstractExtensibleXRDObjectUnmarshaller;
import org.openxrd.xrd.core.Alias;
import org.openxrd.xrd.core.Expires;
import org.openxrd.xrd.core.Link;
import org.openxrd.xrd.core.Subject;
import org.openxrd.xrd.core.Property;
import org.openxrd.xrd.core.XRD;
import org.w3c.dom.Attr;

/**
 * A thread-safe unmarshaller for {@link XRD}.
 */
public class XRDUnmarshaller extends AbstractExtensibleXRDObjectUnmarshaller {

    /** {@inheritDoc} */
    protected void processAttribute(XMLObject xmlObject, Attr attribute) throws UnmarshallingException {
        XRD xrd = (XRD) xmlObject;

        if (attribute.getLocalName().equals(XRD.ID_ATTRIB_NAME.getLocalPart())
                && attribute.getNamespaceURI().equals(XRD.ID_ATTRIB_NAME.getNamespaceURI())
                && !DatatypeHelper.isEmpty(attribute.getValue())) {
            xrd.setID(attribute.getValue());
            attribute.getOwnerElement().setIdAttributeNode(attribute, true);
        } else {
            super.processAttribute(xmlObject, attribute);
        }
    }

    /** {@inheritDoc} */
    protected void processChildElement(XMLObject parentObject, XMLObject childObject) throws UnmarshallingException {
        XRD xrd = (XRD) parentObject;

        if (childObject instanceof Expires) {
            xrd.setExpires((Expires) childObject);
        } else if (childObject instanceof Subject) {
            xrd.setSubject((Subject) childObject);
        } else if (childObject instanceof Alias) {
            xrd.getAliases().add((Alias) childObject);
        } else if (childObject instanceof Property) {
            xrd.getProperties().add((Property) childObject);
        } else if (childObject instanceof Link) {
            xrd.getLinks().add((Link) childObject);
        } else if (childObject instanceof Signature) {
            xrd.setSignature((Signature) childObject);
        } else {
            super.processChildElement(parentObject, childObject);
        }
    }

}