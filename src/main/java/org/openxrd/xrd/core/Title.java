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
import org.opensaml.xml.util.XMLConstants;
import org.openxrd.common.XRDConstants;
import org.openxrd.xrd.common.XRDObject;

/**
 * XRD Title.
 */
public interface Title extends XRDObject, XSString, AttributeExtensibleXMLObject {

    /** Element local name. */
    public static final String DEFAULT_ELEMENT_LOCAL_NAME = "Title";

    /** Default element name. */
    public static final QName DEFAULT_ELEMENT_NAME = new QName(XRDConstants.XRD_NS, DEFAULT_ELEMENT_LOCAL_NAME,
            XRDConstants.XRD_PREFIX);

    /** Language attribute name. */
    public static final QName LANG_ATTRIB_NAME = new QName(XMLConstants.XML_NS, "lang", XMLConstants.XML_PREFIX);

    /**
     * Get the language of this Title.
     * 
     * @return the ID of this XRD
     */
    public String getLanguage();

    /**
     * Set the language of this Title.
     * 
     * @param newLanguage the language of this Title
     */
    public void setLanguage(String newLanguage);

}