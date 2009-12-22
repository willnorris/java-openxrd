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

import org.openxrd.xrd.common.impl.AbstractExtensibleXRDObject;
import org.openxrd.xrd.core.Title;

/**
 * A concrete implementation of {@link Title}.
 */
public class TitleImpl extends AbstractExtensibleXRDObject implements Title {

    /** Title value. */
    private String value;

    /** Title language. */
    private String language;

    /**
     * Constructor.
     * 
     * @param namespaceURI the namespace the element is in
     * @param elementLocalName the local name of the XML element this Object represents
     * @param namespacePrefix the prefix for the given namespace
     */
    protected TitleImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
        super(namespaceURI, elementLocalName, namespacePrefix);
    }

    /** {@inheritDoc} */
    public String getValue() {
        return value;
    }

    /** {@inheritDoc} */
    public void setValue(String newValue) {
        value = prepareForAssignment(value, newValue);
    }

    /** {@inheritDoc} */
    public String getLanguage() {
        return language;
    }

    /** {@inheritDoc} */
    public void setLanguage(String newLanguage) {
        language = prepareForAssignment(language, newLanguage);
    }

}