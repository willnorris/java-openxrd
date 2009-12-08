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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.xml.XMLObject;
import org.opensaml.xml.signature.KeyInfo;
import org.opensaml.xml.util.IndexedXMLObjectChildrenList;
import org.opensaml.xml.util.XMLObjectChildrenList;
import org.openxrd.xrd.common.impl.AbstractXRDObject;
import org.openxrd.xrd.core.Link;

/**
 * A concrete implementation of {@link Link}.
 */
public class LinkImpl extends AbstractXRDObject implements Link {

    /** Rel. */
    private String rel;

    /** Media Type. */
    private String type;

    /** Href. */
    private String href;

    /** Template. */
    private String template;

    /** KeyInfos. */
    private final XMLObjectChildrenList<KeyInfo> keyInfos;

    /** Unknown children of this element. */
    private IndexedXMLObjectChildrenList<XMLObject> unknownElements;

    /**
     * Constructor.
     * 
     * @param namespaceURI the namespace the element is in
     * @param elementLocalName the local name of the XML element this Object represents
     * @param namespacePrefix the prefix for the given namespace
     */
    public LinkImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
        super(namespaceURI, elementLocalName, namespacePrefix);

        keyInfos = new XMLObjectChildrenList<KeyInfo>(this);
        unknownElements = new IndexedXMLObjectChildrenList<XMLObject>(this);
    }

    /** {@inheritDoc} */
    public String getHref() {
        return href;
    }

    /** {@inheritDoc} */
    public String getRel() {
        return rel;
    }

    /** {@inheritDoc} */
    public String getTemplate() {
        return template;
    }

    /** {@inheritDoc} */
    public String getType() {
        return type;
    }

    /** {@inheritDoc} */
    public void setHref(String newHref) {
        href = prepareForAssignment(href, newHref);
    }

    /** {@inheritDoc} */
    public void setRel(String newRel) {
        rel = prepareForAssignment(rel, newRel);
    }

    /** {@inheritDoc} */
    public void setTemplate(String newTemplate) {
        template = prepareForAssignment(template, newTemplate);
    }

    /** {@inheritDoc} */
    public void setType(String newType) {
        type = prepareForAssignment(type, newType);
    }

    /** {@inheritDoc} */
    public List<KeyInfo> getKeyInfos() {
        return keyInfos;
    }

    /** {@inheritDoc} */
    public List<XMLObject> getOrderedChildren() {
        ArrayList<XMLObject> children = new ArrayList<XMLObject>();

        children.addAll(getKeyInfos());

        children.addAll(getUnknownXMLObjects());

        return Collections.unmodifiableList(children);
    }

    /** {@inheritDoc} */
    public List<XMLObject> getUnknownXMLObjects() {
        return unknownElements;
    }

    /** {@inheritDoc} */
    public List<XMLObject> getUnknownXMLObjects(QName typeOrName) {
        return (List<XMLObject>) unknownElements.subList(typeOrName);
    }

}