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
import org.opensaml.xml.util.DatatypeHelper;
import org.openxrd.xrd.common.impl.AbstractXRDObjectUnmarshaller;
import org.openxrd.xrd.core.Property;
import org.w3c.dom.Attr;

/**
 * A thread-safe Unmarshaller for {@link Property}.
 */
public class PropertyUnmarshaller extends AbstractXRDObjectUnmarshaller {

    /** {@inheritDoc} */
    protected void processAttribute(XMLObject xmlObject, Attr attribute) throws UnmarshallingException {
        Property type = (Property) xmlObject;

        if (attribute.getLocalName().equals(Property.TYPE_ATTRIB_NAME) && !DatatypeHelper.isEmpty(attribute.getValue())) {
            type.setType(attribute.getValue());
        } else {
            super.processAttribute(xmlObject, attribute);
        }
    }

    /** {@inheritDoc} */
    protected void processElementContent(XMLObject xmlObject, String elementContent) {
        Property type = (Property) xmlObject;

        type.setValue(elementContent);
    }

}