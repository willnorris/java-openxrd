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

import org.openxrd.common.xml.XRDConstants;
import org.openxrd.xrd.common.impl.AbstractXRDObjectBuilder;
import org.openxrd.xrd.core.TargetAuthority;

/**
 * Builder for {@link TargetAuthorityImpl} objects.
 */
public class TargetAuthorityBuilder extends AbstractXRDObjectBuilder<TargetAuthority> {

    /** Constructor. */
    public TargetAuthorityBuilder() {
    }

    /** {@inheritDoc} */
    public TargetAuthority buildObject() {
        return buildObject(XRDConstants.XRDTRUST_NS, TargetAuthority.DEFAULT_ELEMENT_LOCAL_NAME,
                XRDConstants.XRDTRUST_PREFIX);
    }

    /** {@inheritDoc} */
    public TargetAuthority buildObject(String namespaceURI, String localName, String namespacePrefix) {
        return new TargetAuthorityImpl(namespaceURI, localName, namespacePrefix);
    }

}