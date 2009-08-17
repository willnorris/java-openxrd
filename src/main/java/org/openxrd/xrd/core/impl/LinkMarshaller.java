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
import org.openxrd.xrd.common.impl.AbstractExtensibleXRDObjectMarshaller;
import org.openxrd.xrd.core.Link;
import org.w3c.dom.Element;

/**
 * A thread-safe marshaller for {@link Link}.
 */
public class LinkMarshaller extends AbstractExtensibleXRDObjectMarshaller {

    /** {@inheritDoc} */
    protected void marshallAttributes(XMLObject xmlObject, Element domElement) throws MarshallingException {
        Link link = (Link) xmlObject;

        if (link.getPriority() != null) {
            domElement.setAttributeNS(null, Link.PRIORITY_ATTRIB_NAME, link.getPriority().toString());
        }

        super.marshallAttributes(xmlObject, domElement);
    }

}