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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.openxrd.discovery.DiscoveryException;
import org.openxrd.discovery.HttpDiscoveryMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for Discovery Methods which use HTTP.
 */
public abstract class AbstractHttpDiscoveryMethod extends AbstractDiscoveryMethod implements HttpDiscoveryMethod {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(AbstractHttpDiscoveryMethod.class);

    /** HTTP Client. */
    private HttpClient httpClient;

    /** {@inheritDoc} */
    public HttpClient getHttpClient() {
        return httpClient;
    }

    /** {@inheritDoc} */
    public void setHttpClient(HttpClient newHttpClient) {
        httpClient = newHttpClient;
    }

    /**
     * Fetch the contents of the specified URI using the internal HTTP client.
     * 
     * @param uri URI to fetch
     * @return HTTP response
     * @throws IOException in case of a problem or the connection was aborted
     */
    protected HttpResponse fetch(URI uri) throws IOException {
        LOG.debug("Fetching URI: {}", uri.toString());

        HttpGet httpGet = new HttpGet(uri);
        HttpResponse response = httpClient.execute(httpGet);

        return response;
    }

    /** {@inheritDoc} */
    public String getXRDContent(URI uri) throws DiscoveryException {
        URI xrdLocation = getXRDLocation(uri);

        if (xrdLocation == null) {
            throw new DiscoveryException("Unable to discover location of XRD document.");
        }

        try {
            HttpResponse response = fetch(xrdLocation);
            HttpEntity entity = response.getEntity();
            
            if (entity != null) {
                return EntityUtils.toString(entity);
            } else {
                entity.consumeContent();
                return null;
            }
        } catch (IOException e) {
            throw new DiscoveryException(e);
        }
    }

    /**
     * Get the location of the XRD document.
     * 
     * @param uri URI to discover XRD document for
     * @return locate of XRD document
     * @throws DiscoveryException if unable to discover location of XRD document
     */
    public abstract URI getXRDLocation(URI uri) throws DiscoveryException;

}