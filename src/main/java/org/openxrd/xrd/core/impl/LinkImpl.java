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
import org.opensaml.xml.signature.KeyInfo;
import org.opensaml.xml.util.XMLObjectChildrenList;
import org.openxrd.xrd.common.impl.AbstractXRDObject;
import org.openxrd.xrd.core.Extensions;
import org.openxrd.xrd.core.Link;
import org.openxrd.xrd.core.MediaType;
import org.openxrd.xrd.core.Rel;
import org.openxrd.xrd.core.Subject;
import org.openxrd.xrd.core.URI;
import org.openxrd.xrd.core.URITemplate;

/**
 * A concrete implementation of {@link Link}.
 */
public class LinkImpl extends AbstractXRDObject implements Link {

    /** Subject. */
    private Subject subject;

    /** Extensions. */
    private Extensions extensions;

    /** Rels. */
    private final XMLObjectChildrenList<Rel> rels;

    /** Media Types. */
    private final XMLObjectChildrenList<MediaType> mediaTypes;

    /** URIs. */
    private final XMLObjectChildrenList<URI> uris;

    /** URITemplates. */
    private final XMLObjectChildrenList<URITemplate> uriTemplates;

    /** KeyInfos. */
    private final XMLObjectChildrenList<KeyInfo> keyInfos;

    /**
     * Constructor.
     * 
     * @param namespaceURI the namespace the element is in
     * @param elementLocalName the local name of the XML element this Object represents
     * @param namespacePrefix the prefix for the given namespace
     */
    public LinkImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
        super(namespaceURI, elementLocalName, namespacePrefix);

        mediaTypes = new XMLObjectChildrenList<MediaType>(this);
        rels = new XMLObjectChildrenList<Rel>(this);
        uris = new XMLObjectChildrenList<URI>(this);
        uriTemplates = new XMLObjectChildrenList<URITemplate>(this);
        keyInfos = new XMLObjectChildrenList<KeyInfo>(this);
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
    public Extensions getExtensions() {
        return extensions;
    }

    /** {@inheritDoc} */
    public void setExtensions(Extensions newExtensions) {
        extensions = prepareForAssignment(extensions, newExtensions);
    }

    /** {@inheritDoc} */
    public List<Rel> getRels() {
        return rels;
    }

    /** {@inheritDoc} */
    public List<MediaType> getMediaTypes() {
        return mediaTypes;
    }

    /** {@inheritDoc} */
    public List<URI> getURIs() {
        return uris;
    }

    /** {@inheritDoc} */
    public List<URITemplate> getURITemplates() {
        return uriTemplates;
    }

    /** {@inheritDoc} */
    public List<KeyInfo> getKeyInfos() {
        return keyInfos;
    }

    /** {@inheritDoc} */
    public List<XMLObject> getOrderedChildren() {
        ArrayList<XMLObject> children = new ArrayList<XMLObject>();

        if (getSubject() != null) {
            children.add(getSubject());
        }

        if (getExtensions() != null) {
            children.add(getExtensions());
        }

        children.addAll(getRels());
        children.addAll(getMediaTypes());
        children.addAll(getURIs());
        children.addAll(getURITemplates());
        children.addAll(getKeyInfos());

        return Collections.unmodifiableList(children);
    }

}