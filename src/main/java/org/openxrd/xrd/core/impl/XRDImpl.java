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
import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.xml.XMLObject;
import org.opensaml.xml.util.AttributeMap;
import org.opensaml.xml.util.IndexedXMLObjectChildrenList;
import org.openxrd.xrd.common.impl.AbstractXRDObject;
import org.openxrd.xrd.core.Alias;
import org.openxrd.xrd.core.Expires;
import org.openxrd.xrd.core.Link;
import org.openxrd.xrd.core.Subject;
import org.openxrd.xrd.core.Type;
import org.openxrd.xrd.core.XRD;

/**
 * A concrete implementation of {@link XRD}.
 */
public class XRDImpl extends AbstractXRDObject implements XRD {

    /** Aliases. */
    private List<Alias> aliases;

    /** Expiration. */
    private Expires expires;

    /** Links. */
    private List<Link> links;

    /** Subject. */
    private Subject subject;

    /** Types. */
    private List<Type> types;    

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

        aliases = new ArrayList<Alias>();
        links = new ArrayList<Link>();
        types = new ArrayList<Type>();
        unknownAttributes = new AttributeMap(this);
        unknownElements = new IndexedXMLObjectChildrenList<XMLObject>(this);
    }

    /** {@inheritDoc} */
    public List<Alias> getAliases() {
        return aliases;
    }

    /** {@inheritDoc} */
    public Expires getExpires() {
        return expires;
    }

    /** {@inheritDoc} */
    public List<Link> getLinks() {
        return links;
    }

    /** {@inheritDoc} */
    public Subject getSubject() {
        return subject;
    }

    /** {@inheritDoc} */
    public List<Type> getTypes() {
        return types;
    }

    /** {@inheritDoc} */
    public List<XMLObject> getOrderedChildren() {
        // TODO Auto-generated method stub
        return null;
    }

    /** {@inheritDoc} */
    public AttributeMap getUnknownAttributes() {
        return unknownAttributes;
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