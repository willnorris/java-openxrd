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

package org.openxrd.xrd.core;

import javax.xml.namespace.QName;

import org.opensaml.xml.AttributeExtensibleXMLObject;
import org.opensaml.xml.schema.XSString;
import org.openxrd.common.XRDConstants;
import org.openxrd.xrd.common.XRDObject;

/**
 * XRD Property.
 */
public interface Property extends XRDObject, XSString, AttributeExtensibleXMLObject {

    /** Element local name. */
    public static final String DEFAULT_ELEMENT_LOCAL_NAME = "Property";

    /** Default element name. */
    public static final QName DEFAULT_ELEMENT_NAME = new QName(XRDConstants.XRD_NS, DEFAULT_ELEMENT_LOCAL_NAME,
            XRDConstants.XRD_PREFIX);

    /** Type attribute name. */
    public static final String TYPE_ATTRIB_NAME = "type";

    /**
     * Get the property type.
     * 
     * @return property type
     */
    public String getType();

    /**
     * Set the property type.
     * 
     * @param newType property type
     */
    public void setType(String newType);

}