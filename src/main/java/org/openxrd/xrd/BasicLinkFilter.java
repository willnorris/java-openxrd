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

import org.openxrd.xrd.core.Link;

/**
 * Basic link filter that matches links based on Rel and MediaType values.
 */
public class BasicLinkFilter implements LinkFilter {

    /** Rel to match against link. */
    private String rel;

    /** MediaTypes to match against link. */
    private String type;

    /**
     * Constructor.
     * 
     * @param relValue rel value to match
     * @param mediaType media type value to match
     */
    public BasicLinkFilter(String relValue, String mediaType) {
        rel = relValue;
        type = mediaType;
    }

    /** {@inheritDoc} */
    public boolean matches(Link link) {

        if (rel != null && !rel.equals(link.getRel())) {
            return false;
        }

        if (type != null && !type.equals(link.getType())) {
            return false;
        }

        return true;
    }

}