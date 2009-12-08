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

    /** Rel attribute name. */
    public static final String REL_ATTRIB_NAME = "rel";

    /** Type attribute name. */
    public static final String TYPE_ATTRIB_NAME = "type";

    /** Href attribute name. */
    public static final String HREF_ATTRIB_NAME = "href";

    /** Template attribute name. */
    public static final String TEMPLATE_ATTRIB_NAME = "template";

    /**
     * Get the rel for this link.
     * 
     * @return the rel for this link
     */
    public String getRel();

    /**
     * Set the rel for this link.
     * 
     * @param newRel the rel for this link
     */
    public void setRel(String newRel);

    /**
     * Get the media type for this link.
     * 
     * @return the media type for this link
     */
    public String getType();

    /**
     * Set the media type for this link.
     * 
     * @param newType the media type for this link
     */
    public void setType(String newType);

    /**
     * Get the href for this link.
     * 
     * @return the href for this link
     */
    public String getHref();

    /**
     * Set the href for this link.
     * 
     * @param newHref the href for this link
     */
    public void setHref(String newHref);

    /**
     * Get the template for this link.
     * 
     * @return the template for this link
     */
    public String getTemplate();

    /**
     * Set the template for this link.
     * 
     * @param newTemplate the template for this link
     */
    public void setTemplate(String newTemplate);

    /**
     * Get the key infos for this link.
     * 
     * @return the key infos for this link.
     */
    public List<KeyInfo> getKeyInfos();

}