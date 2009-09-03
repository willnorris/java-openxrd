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

package org.openxrd.discovery;

import java.net.URI;

import org.opensaml.xml.parse.ParserPool;
import org.openxrd.xrd.core.XRD;

/**
 * A Discovery Method provides one mechanism for discovering the XRD document for a URI.
 */
public interface DiscoveryMethod {

    /**
     * Get the XML parser pool.
     * 
     * @return the parser pool
     */
    public ParserPool getParserPool();

    /**
     * Set the XML parser pool.
     * 
     * @param newParserPool the parser pool
     */
    public void setParserPool(ParserPool newParserPool);

    /**
     * Discover the XRD document for the given resource URI.
     * 
     * @param uri resource to get XRD document for
     * @return XRD document for the given resource
     * @throws DiscoveryException if error occurs while discovering or fetching XRD document
     */
    public XRD discoverXRD(URI uri) throws DiscoveryException;

}