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

import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.xml.ElementExtensibleXMLObject;
import org.opensaml.xml.util.XMLConstants;
import org.openxrd.common.XRDConstants;
import org.openxrd.xrd.common.SignableXRDObject;

/**
 * XRD.
 */
public interface XRD extends SignableXRDObject, ElementExtensibleXMLObject {

    /** Element local name. */
    public static final String DEFAULT_ELEMENT_LOCAL_NAME = "XRD";

    /** Default element name. */
    public static final QName DEFAULT_ELEMENT_NAME = new QName(XRDConstants.XRD_NS, DEFAULT_ELEMENT_LOCAL_NAME,
            XRDConstants.XRD_PREFIX);

    /** ID attribute name. */
    public static final QName ID_ATTRIB_NAME = new QName(XMLConstants.XML_NS, "id", XMLConstants.XML_PREFIX);

    /**
     * Get the ID of this XRD.
     * 
     * @return the ID of this XRD
     */
    public String getID();

    /**
     * Set the ID of this XRD.
     * 
     * @param newID the ID of this XRD
     */
    public void setID(String newID);

    /**
     * Get the expiration of this XRD.
     * 
     * @return the expiration of this XRD
     */
    public Expires getExpires();

    /**
     * Set the expiration of this XRD.
     * 
     * @param newExpires the expiration of this XRD
     */
    public void setExpires(Expires newExpires);

    /**
     * Get the subject of this XRD.
     * 
     * @return the subject of this XRD
     */
    public Subject getSubject();

    /**
     * Set the subject of this XRD.
     * 
     * @param newSubject the subject of this XRD
     */
    public void setSubject(Subject newSubject);

    /**
     * Get the list of aliases for this XRD.
     * 
     * @return the list of aliases for this XRD
     */
    public List<Alias> getAliases();

    /**
     * Get the list of types for this XRD.
     * 
     * @return the list of types for this XRD
     */
    public List<Property> getProperties();

    /**
     * Get the list of links for this XRD.
     * 
     * @return the list of links for this XRD
     */
    public List<Link> getLinks();

}