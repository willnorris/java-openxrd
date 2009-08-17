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

package org.openxrd.xrd.common.impl;

import java.util.Map.Entry;

import javax.xml.namespace.QName;

import org.opensaml.xml.Configuration;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.AbstractXMLObjectMarshaller;
import org.opensaml.xml.io.Marshaller;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.util.XMLHelper;
import org.openxrd.xrd.common.XRDObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 * A thread safe, abstract implementation of the {@link Marshaller} interface that handles most of the boilerplate code
 * for XRD Marshallers.
 */
public class AbstractXRDObjectMarshaller extends AbstractXMLObjectMarshaller {

    /**
     * Marshall all non-XRD attributes. Extending implementations should override this method if they have specific
     * attributes to marshall into the Element.
     * 
     * {@inheritDoc}
     */
    protected void marshallAttributes(XMLObject xmlObject, Element domElement) throws MarshallingException {
        XRDObject xrdObject = (XRDObject) xmlObject;

        Attr attr;
        for (Entry<QName, String> entry : xrdObject.getUnknownAttributes().entrySet()) {
            // TODO: ensure attribute is not in the XRD namespace
            attr = XMLHelper.constructAttribute(domElement.getOwnerDocument(), entry.getKey());
            attr.setValue(entry.getValue());
            domElement.setAttributeNodeNS(attr);

            if (Configuration.isIDAttribute(entry.getKey())
                    || xrdObject.getUnknownAttributes().isIDAttribute(entry.getKey())) {
                attr.getOwnerElement().setIdAttributeNode(attr, true);
            }
        }
    }

    /**
     * No-op method. Extending implementations should override this method if they have text content to marshall into
     * the Element.
     * 
     * {@inheritDoc}
     */
    protected void marshallElementContent(XMLObject xmlObject, Element domElement) throws MarshallingException {

    }

}