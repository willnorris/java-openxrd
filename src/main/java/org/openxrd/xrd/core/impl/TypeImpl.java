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

import org.opensaml.xml.schema.XSBooleanValue;
import org.openxrd.xrd.common.impl.AbstractXRDObject;
import org.openxrd.xrd.core.Type;

/**
 * A concrete implementation of {@link Type}.
 */
public class TypeImpl extends AbstractXRDObject implements Type {

    /** Type value. */
    private String value;

    /** Whether this Type is required. */
    private XSBooleanValue required;

    /**
     * Constructor.
     * 
     * @param namespaceURI the namespace the element is in
     * @param elementLocalName the local name of the XML element this Object represents
     * @param namespacePrefix the prefix for the given namespace
     */
    protected TypeImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
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
    public Boolean isRequired() {
        if (required != null) {
            return required.getValue();
        }
        
        return Boolean.FALSE;
    }


    /** {@inheritDoc} */
    public XSBooleanValue isRequiredXSBoolean() {
        return required;
    }
    
    /** {@inheritDoc} */
    public void setRequired(Boolean newRequired) {
        if (newRequired != null) {
            setRequired(new XSBooleanValue(newRequired, false));    
        } else {
            required = prepareForAssignment(required, null);
        }   
    }
    
    /** {@inheritDoc} */
    public void setRequired(XSBooleanValue newRequired) {
        required = prepareForAssignment(required, newRequired);
    }

}