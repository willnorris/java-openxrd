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

import org.opensaml.xml.XMLObject;
import org.opensaml.xml.util.XMLObjectChildrenList;
import org.opensaml.xml.validation.AbstractValidatingXMLObject;
import org.openxrd.xrd.core.XRD;
import org.openxrd.xrd.core.XRDSequence;

/**
 * A concrete implementation of {@link XRDSequence}.
 */
public class XRDSequenceImpl extends AbstractValidatingXMLObject implements XRDSequence {

    /** Ref. */
    private String ref;

    /** XRDs. */
    private final XMLObjectChildrenList<XRD> xrds;

    /**
     * Constructor.
     * 
     * @param namespaceURI the namespace the element is in
     * @param elementLocalName the local name of the XML element this Object represents
     * @param namespacePrefix the prefix for the given namespace
     */
    protected XRDSequenceImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
        super(namespaceURI, elementLocalName, namespacePrefix);

        xrds = new XMLObjectChildrenList<XRD>(this);
    }

    /** {@inheritDoc} */
    public String getRef() {
        return ref;
    }

    /** {@inheritDoc} */
    public void setRef(String newRef) {
        ref = prepareForAssignment(ref, newRef);
    }

    /** {@inheritDoc} */
    public List<XRD> getXRDs() {
        return xrds;
    }

    /** {@inheritDoc} */
    public List<XMLObject> getOrderedChildren() {
        ArrayList<XMLObject> children = new ArrayList<XMLObject>();

        children.addAll(getXRDs());

        return Collections.unmodifiableList(children);
    }

}