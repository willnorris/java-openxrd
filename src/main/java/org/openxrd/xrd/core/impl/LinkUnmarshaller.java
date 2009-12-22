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
import org.opensaml.xml.signature.KeyInfo;
import org.opensaml.xml.util.DatatypeHelper;
import org.openxrd.xrd.common.impl.AbstractXRDObjectUnmarshaller;
import org.openxrd.xrd.core.Link;
import org.openxrd.xrd.core.Title;
import org.w3c.dom.Attr;

/**
 * A thread-safe unmarshaller for {@link Link}.
 */
public class LinkUnmarshaller extends AbstractXRDObjectUnmarshaller {

    /** {@inheritDoc} */
    protected void processChildElement(XMLObject parentObject, XMLObject childObject) throws UnmarshallingException {
        Link link = (Link) parentObject;

        if (childObject instanceof Title) {
            link.getTitles().add((Title) childObject);
        } else if (childObject instanceof KeyInfo) {
            link.getKeyInfos().add((KeyInfo) childObject);
        } else {
            super.processChildElement(parentObject, childObject);
        }
    }

    /** {@inheritDoc} */
    protected void processAttribute(XMLObject xmlObject, Attr attribute) throws UnmarshallingException {
        Link link = (Link) xmlObject;

        if (attribute.getLocalName().equals(Link.HREF_ATTRIB_NAME) && !DatatypeHelper.isEmpty(attribute.getValue())) {
            link.setHref(attribute.getValue());
        } else if (attribute.getLocalName().equals(Link.REL_ATTRIB_NAME)
                && !DatatypeHelper.isEmpty(attribute.getValue())) {
            link.setRel(attribute.getValue());
        } else if (attribute.getLocalName().equals(Link.TEMPLATE_ATTRIB_NAME)
                && !DatatypeHelper.isEmpty(attribute.getValue())) {
            link.setTemplate(attribute.getValue());
        } else if (attribute.getLocalName().equals(Link.TYPE_ATTRIB_NAME)
                && !DatatypeHelper.isEmpty(attribute.getValue())) {
            link.setType(attribute.getValue());
        } else {
            super.processAttribute(xmlObject, attribute);
        }
    }

}