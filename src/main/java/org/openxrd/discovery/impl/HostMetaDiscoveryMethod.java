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

import java.net.URI;
import java.net.URISyntaxException;

import org.openxrd.discovery.DiscoveryException;

/**
 * Discovery Method which uses a host's host-meta file to find XRD for a resource.
 */
public class HostMetaDiscoveryMethod extends AbstractHttpDiscoveryMethod {

    /** Path for host-meta document. */
    private static final String HOST_META_PATH = "/.well-known/host-meta";

    /** {@inheritDoc} */
    public URI getXRDLocation(URI uri) throws DiscoveryException {
        try {
            return new URI(uri.getScheme(), uri.getHost(), HOST_META_PATH, null);
            // TODO: parse host-meta to find actual XRD location
        } catch (URISyntaxException e) {
            throw new DiscoveryException(e);
        }
    }

}
