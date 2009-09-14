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

package org.openxrd.discovery.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.tags.BodyTag;
import org.htmlparser.tags.HeadTag;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.NodeVisitor;
import org.opensaml.xml.util.LazyList;
import org.openxrd.common.XRDConstants;
import org.openxrd.discovery.DiscoveryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Discovery Method which retrieves the location of the XRD Document from Http Headers.
 */
public class HtmlLinkDiscoveryMethod extends AbstractHttpDiscoveryMethod {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(HtmlLinkDiscoveryMethod.class);

    /** {@inheritDoc} */
    public URI getXRDLocation(URI uri) throws DiscoveryException {

        try {
            HttpResponse response = fetch(uri);
            HttpEntity entity = response.getEntity();
            
            if (entity == null) {
                entity.consumeContent();
                return null;
            }
            
            String content = EntityUtils.toString(entity);
            Parser htmlParser = Parser.createParser(content, null);
            
            LinkVisitor linkVisitor = new LinkVisitor();
            htmlParser.visitAllNodesWith(linkVisitor);

            for (Tag tag : linkVisitor.getLinks()) {
                if (!XRDConstants.XRD_MIME_TYPE.equals(tag.getAttribute("type"))) {
                    continue;
                }

                if (!XRDConstants.XRD_REL_DESCRIBEDBY.equalsIgnoreCase(tag.getAttribute("rel"))) {
                    continue;
                }

                try {
                    URL xrdLocation = new URL(uri.toURL(), tag.getAttribute("href"));
                    LOG.debug("Found XRD location: {}", xrdLocation.toString());

                    return xrdLocation.toURI();
                } catch (URISyntaxException e) {
                    continue;
                }
            }

            return null;
        } catch (IOException e) {
            throw new DiscoveryException(e);
        } catch (ParserException e) {
            throw new DiscoveryException(e);
        }
    }

    /**
     * Node Visitor implementation that stores all HTML Link elements that appear inside of the HTML Head element.
     */
    private class LinkVisitor extends NodeVisitor {

        /** Whether the parser is currently inside the HTML Head element. */
        private boolean inHead;

        /** List of HTML link elements. */
        private List<Tag> links;

        /** Constructor. */
        public LinkVisitor() {
            inHead = false;
            links = new LazyList<Tag>();
        }

        /** {@inheritDoc} */
        public void visitTag(Tag tag) {
            if (tag instanceof HeadTag) {
                inHead = true;
            } else if (tag instanceof BodyTag) {
                inHead = false;
            } else if (tag.getTagName().equalsIgnoreCase("link")) {
                if (inHead) {
                    links.add(tag);
                }
            }
        }

        /** {@inheritDoc} */
        public void visitEndTag(Tag tag) {
            if (tag.getTagName().equalsIgnoreCase("head")) {
                inHead = false;
            }
        }

        /**
         * Get the list of HTML Link elements.
         * 
         * @return the list of HTML Link elements
         */
        public List<Tag> getLinks() {
            return links;
        }
    }
}