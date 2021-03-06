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

import org.joda.time.DateTime;
import org.openxrd.xrd.common.impl.AbstractExtensibleXRDObject;
import org.openxrd.xrd.core.Expires;

/**
 * A concrete implementation of {@link Expires}.
 */
public class ExpiresImpl extends AbstractExtensibleXRDObject implements Expires {

    /** Expires value. */
    private DateTime value;

    /**
     * Constructor.
     * 
     * @param namespaceURI the namespace the element is in
     * @param elementLocalName the local name of the XML element this Object represents
     * @param namespacePrefix the prefix for the given namespace
     */
    public ExpiresImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
        super(namespaceURI, elementLocalName, namespacePrefix);
    }

    /** {@inheritDoc} */
    public DateTime getValue() {
        return value;
    }

    /** {@inheritDoc} */
    public void setValue(DateTime newValue) {
        value = prepareForAssignment(value, newValue);
    }

}