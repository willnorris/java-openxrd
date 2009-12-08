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

package org.openxrd.xrd;

import java.util.ArrayList;
import java.util.List;

import org.openxrd.common.XRDConstants;
import org.openxrd.xrd.core.Link;
import org.openxrd.xrd.core.XRD;

/**
 * XRD Utilities.
 */
public class XRDUtils {

    /**
     * Constructor.
     */
    protected XRDUtils() {
    }

    /**
     * Get all linked resources of the given XRD that have the specified rel value.
     * 
     * @param xrd XRD to get linked resources from
     * @param rel Rel value used to select linked resources
     * @return list of linked resources that have the specified rel value
     */
    public static List<Link> getLinkedResources(XRD xrd, String rel) {
        BasicLinkFilter criteria = new BasicLinkFilter(rel, null);
        return getLinkedResources(xrd, criteria);
    }

    /**
     * Get all linked resources of the given XRD that match the specified selection criteria.
     * 
     * @param xrd XRD to get linked resources from
     * @param criteria Selection criteria used to select linked resources
     * @return list of linked resources that match the specified selection criteria
     */
    public static List<Link> getLinkedResources(XRD xrd, LinkFilter criteria) {
        List<Link> relatedLinks = new ArrayList<Link>();

        for (Link link : xrd.getLinks()) {
            if (criteria.matches(link)) {
                relatedLinks.add(link);
            }
        }

        return relatedLinks;
    }

    /**
     * Get all linked XRDs of the given XRD.
     * 
     * @param xrd XRD to get linked XRDs from
     * @return list of linked XRDs
     */
    public static List<Link> getLinkedXRDs(XRD xrd) {
        return getLinkedResources(xrd, XRDConstants.XRD_REL_SEEALSO);
    }

}