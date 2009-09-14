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

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.openxrd.common.XRDConstants;
import org.openxrd.discovery.DiscoveryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Discovery Method which retrieves the location of the XRD Document from Http Headers.
 */
public class HttpHeaderDiscoveryMethod extends AbstractHttpDiscoveryMethod {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(HttpHeaderDiscoveryMethod.class);

    /** Name of the link HTTP Header. */
    private static final String LINK_HEADER_NAME = "Link";

    /** {@inheritDoc} */
    public URI getXRDLocation(URI uri) throws DiscoveryException {
        HttpResponse response;

        try {
            response = fetch(uri);
            response.getEntity().consumeContent();
        } catch (IOException e) {
            throw new DiscoveryException(e);
        }

        Header[] linkHeaders = response.getHeaders(LINK_HEADER_NAME);
        LOG.info("Found {} link headers", linkHeaders.length);

        for (Header header : linkHeaders) {
            for (HeaderElement element : header.getElements()) {
                if (!XRDConstants.XRD_REL_DESCRIBEDBY.equals(element.getParameterByName("rel").getValue())) {
                    continue;
                }
                if (!XRDConstants.XRD_MIME_TYPE.equals(element.getParameterByName("type").getValue())) {
                    continue;
                }

                String xrdURI = element.getName().substring(1, element.getName().length() - 1);

                try {
                    return new URI(xrdURI);
                } catch (URISyntaxException e) {
                    throw new DiscoveryException(e);
                }
            }
        }

        return null;
    }

}