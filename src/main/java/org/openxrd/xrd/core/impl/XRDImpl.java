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
import org.opensaml.xml.util.AttributeMap;
import org.opensaml.xml.util.IndexedXMLObjectChildrenList;
import org.opensaml.xml.util.XMLObjectChildrenList;
import org.openxrd.xrd.common.impl.AbstractSignableXRDObject;
import org.openxrd.xrd.core.Alias;
import org.openxrd.xrd.core.Expires;
import org.openxrd.xrd.core.Link;
import org.openxrd.xrd.core.Subject;
import org.openxrd.xrd.core.Type;
import org.openxrd.xrd.core.XRD;

/**
 * A concrete implementation of {@link XRD}.
 */
public class XRDImpl extends AbstractSignableXRDObject implements XRD {

    /** ID. */
    private String id;

    /** Expiration. */
    private Expires expires;

    /** Subject. */
    private Subject subject;

    /** Aliases. */
    private final XMLObjectChildrenList<Alias> aliases;

    /** Types. */
    private final XMLObjectChildrenList<Type> types;

    /** Links. */
    private final XMLObjectChildrenList<Link> links;

    /** Unknown attributes for this element. */
    private AttributeMap unknownAttributes;

    /** Unknown children of this element. */
    private IndexedXMLObjectChildrenList<XMLObject> unknownElements;

    /**
     * Constructor.
     * 
     * @param namespaceURI the namespace the element is in
     * @param elementLocalName the local name of the XML element this Object represents
     * @param namespacePrefix the prefix for the given namespace
     */
    protected XRDImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
        super(namespaceURI, elementLocalName, namespacePrefix);

        aliases = new XMLObjectChildrenList<Alias>(this);
        links = new XMLObjectChildrenList<Link>(this);
        types = new XMLObjectChildrenList<Type>(this);

        unknownAttributes = new AttributeMap(this);
        unknownElements = new IndexedXMLObjectChildrenList<XMLObject>(this);
    }

    /** {@inheritDoc} */
    public String getID() {
        return id;
    }

    /** {@inheritDoc} */
    public void setID(String newID) {
        String oldID = id;
        id = prepareForAssignment(id, newID);
        registerOwnID(oldID, newID);
    }

    /** {@inheritDoc} */
    public Expires getExpires() {
        return expires;
    }

    /** {@inheritDoc} */
    public void setExpires(Expires newExpires) {
        expires = prepareForAssignment(expires, newExpires);
    }

    /** {@inheritDoc} */
    public Subject getSubject() {
        return subject;
    }

    /** {@inheritDoc} */
    public void setSubject(Subject newSubject) {
        subject = prepareForAssignment(subject, newSubject);
    }

    /** {@inheritDoc} */
    public List<Alias> getAliases() {
        return aliases;
    }

    /** {@inheritDoc} */
    public List<Type> getTypes() {
        return types;
    }

    /** {@inheritDoc} */
    public List<Link> getLinks() {
        return links;
    }

    /** {@inheritDoc} */
    public String getSignatureReferenceID() {
        return getID();
    }

    /** {@inheritDoc} */
    public AttributeMap getUnknownAttributes() {
        return unknownAttributes;
    }

    /** {@inheritDoc} */
    public List<XMLObject> getOrderedChildren() {
        ArrayList<XMLObject> children = new ArrayList<XMLObject>();

        if (getExpires() != null) {
            children.add(getExpires());
        }

        if (getSubject() != null) {
            children.add(getSubject());
        }

        children.addAll(getAliases());
        children.addAll(getTypes());
        children.addAll(getLinks());

        children.addAll(getUnknownXMLObjects());

        if (getSignature() != null) {
            children.add(getSignature());
        }

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