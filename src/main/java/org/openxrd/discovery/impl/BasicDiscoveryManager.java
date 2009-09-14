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
import java.util.List;

import org.opensaml.xml.util.LazyList;
import org.openxrd.discovery.DiscoveryException;
import org.openxrd.discovery.DiscoveryManager;
import org.openxrd.discovery.DiscoveryMethod;
import org.openxrd.xrd.core.XRD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic Discovery Manager Implementation.
 */
public class BasicDiscoveryManager implements DiscoveryManager {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(BasicDiscoveryManager.class);

    /** Registered Discovery Methods. */
    private List<DiscoveryMethod> discoveryMethods;

    /** Constructor. */
    public BasicDiscoveryManager() {
        discoveryMethods = new LazyList<DiscoveryMethod>();
    }

    /** {@inheritDoc} */
    public XRD discover(URI uri) {
        for (DiscoveryMethod method : discoveryMethods) {
            try {
                LOG.debug("Attempting XRD Discovery for URI: ({}) using {}", uri.toString(), method.getClass()
                        .toString());
                return method.discoverXRD(uri);
            } catch (DiscoveryException e) {
                LOG.info("Discovery Exception: " + e.getMessage());
                // do nothing, move on to next discovery method
            }
        }

        return null;
    }

    /** {@inheritDoc} */
    public List<DiscoveryMethod> getDiscoveryMethods() {
        return discoveryMethods;
    }

}