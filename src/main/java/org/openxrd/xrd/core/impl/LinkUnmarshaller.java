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
import org.openxrd.xrd.common.impl.AbstractExtensibleXRDObjectUnmarshaller;
import org.openxrd.xrd.core.Link;
import org.openxrd.xrd.core.MediaType;
import org.openxrd.xrd.core.Rel;
import org.openxrd.xrd.core.Subject;
import org.openxrd.xrd.core.URI;
import org.openxrd.xrd.core.URITemplate;

/**
 * A thread-safe unmarshaller for {@link Link}.
 */
public class LinkUnmarshaller extends AbstractExtensibleXRDObjectUnmarshaller {

    /** {@inheritDoc} */
    protected void processChildElement(XMLObject parentObject, XMLObject childObject) throws UnmarshallingException {
        Link link = (Link) parentObject;

        if (childObject instanceof Subject) {
            link.setSubject((Subject) childObject);
        } else if (childObject instanceof Rel) {
            link.getRels().add((Rel) childObject);
        } else if (childObject instanceof MediaType) {
            link.getMediaTypes().add((MediaType) childObject);
        } else if (childObject instanceof URI) {
            link.getURIs().add((URI) childObject);
        } else if (childObject instanceof URITemplate) {
            link.getURITemplates().add((URITemplate) childObject);
        } else if (childObject instanceof KeyInfo) {
            link.getKeyInfos().add((KeyInfo) childObject);
        } else {
            super.processChildElement(parentObject, childObject);
        }
    }

}