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
import org.opensaml.xml.signature.KeyInfo;
import org.openxrd.common.XRDConstants;
import org.openxrd.xrd.common.XRDObject;

/**
 * XRD Link.
 */
public interface Link extends XRDObject, ElementExtensibleXMLObject {

    /** Element local name. */
    public static final String DEFAULT_ELEMENT_LOCAL_NAME = "Link";

    /** Default element name. */
    public static final QName DEFAULT_ELEMENT_NAME = new QName(XRDConstants.XRD_NS, DEFAULT_ELEMENT_LOCAL_NAME,
            XRDConstants.XRD_PREFIX);

    /**
     * Get the subject of this link.
     * 
     * @return the subject of this link
     */
    public Subject getSubject();

    /**
     * Set the subject of this link.
     * 
     * @param newSubject the subject of this link
     */
    public void setSubject(Subject newSubject);

    /**
     * Get the list of rels for this link.
     * 
     * @return the list of rels for this link
     */
    public List<Rel> getRels();

    /**
     * Get the list of media types for this link.
     * 
     * @return the list of media types for this link
     */
    public List<MediaType> getMediaTypes();

    /**
     * Get the list of URIs for this link.
     * 
     * @return the list of URIs for this link
     */
    public List<URI> getURIs();

    /**
     * Get the list of URI templates for this link.
     * 
     * @return the list of URI templates for this link
     */
    public List<URITemplate> getURITemplates();

    /**
     * Get the key infos for this link.
     * 
     * @return the key infos for this link.
     */
    public List<KeyInfo> getKeyInfos();

}
