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

import org.opensaml.xml.ElementExtensibleXMLObject;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.Unmarshaller;
import org.opensaml.xml.io.UnmarshallingException;

/**
 * A thread safe, abstract implementation of the {@link Unmarshaller} interface that supports element extensibility.
 */
public class AbstractExtensibleXRDObjectUnmarshaller extends AbstractXRDObjectUnmarshaller {

    /**
     * Unmarshalls all child elements in the <code>xs:any</code> list.
     * 
     * {@inheritDoc}
     */
    protected void processChildElement(XMLObject parentXMLObject, XMLObject childXMLObject)
            throws UnmarshallingException {

        // TODO: make sure child element is not in XRD or XRD-Trust namespaces

        ElementExtensibleXMLObject any = (ElementExtensibleXMLObject) parentXMLObject;
        any.getUnknownXMLObjects().add(childXMLObject);
    }

}