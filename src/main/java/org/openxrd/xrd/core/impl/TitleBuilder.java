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

import org.openxrd.common.XRDConstants;
import org.openxrd.xrd.common.impl.AbstractXRDObjectBuilder;
import org.openxrd.xrd.core.Title;

/**
 * Builder for {@link TitleImpl} objects.
 */
public class TitleBuilder extends AbstractXRDObjectBuilder<Title> {

    /** Constructor. */
    public TitleBuilder() {
    }

    /** {@inheritDoc} */
    public Title buildObject() {
        return buildObject(XRDConstants.XRD_NS, Title.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
    }

    /** {@inheritDoc} */
    public Title buildObject(String namespaceURI, String localName, String namespacePrefix) {
        return new TitleImpl(namespaceURI, localName, namespacePrefix);
    }

}