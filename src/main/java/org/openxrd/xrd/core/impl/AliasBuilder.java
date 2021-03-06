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
import org.openxrd.xrd.core.Alias;

/**
 * Builder for {@link AliasImpl} objects.
 */
public class AliasBuilder extends AbstractXRDObjectBuilder<Alias> {

    /** Constructor. */
    public AliasBuilder() {
    }

    /** {@inheritDoc} */
    public Alias buildObject() {
        return buildObject(XRDConstants.XRD_NS, Alias.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
    }

    /** {@inheritDoc} */
    public Alias buildObject(String namespaceURI, String localName, String namespacePrefix) {
        return new AliasImpl(namespaceURI, localName, namespacePrefix);
    }

}