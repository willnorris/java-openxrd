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
import java.util.List;

import org.openxrd.xrd.core.XRD;

/**
 * A discovery manager is responsible for maintaining a list of registered discovery methods, and then using those
 * methods to discover and fetch the XRD descriptor for a given resource.
 */
public interface DiscoveryManager {

    /**
     * Get list of registered discovery methods.
     * 
     * @return registered discovery methods
     */
    public List<DiscoveryMethod> getDiscoveryMethods();

    /**
     * Discover and fetch the XRD for a given resource URI.
     * 
     * @param uri URI of resource to get XRD document for
     * @return XRD document for the resource, or null if no XRD can be discovered
     */
    public XRD discover(URI uri);

}