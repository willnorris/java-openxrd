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

package org.openxrd.template.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.opensaml.xml.util.LazyMap;

/**
 * Template dictionary which adds the additional "uri" term to the other URI parts, as specified in LRDD.
 */
public class LRDDTemplateDictionary extends URITemplateDictionary {

    private static final String[] terms = { "uri" };

    /** {@inheritDoc} */
    public Map<String, String> getTermValues(String input) {

        Map<String, String> values = new LazyMap<String, String>();

        try {
            URI uri = new URI(input);

            StringBuffer uriTerm = new StringBuffer();
            if (uri.getScheme() != null) {
                uriTerm.append(uri.getScheme()).append(":");
            }
            uriTerm.append(uri.getSchemeSpecificPart());
            values.put("uri", uriTerm.toString());

            values.putAll(getURIParts(uri));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return values;
    }

    /** {@inheritDoc} */
    public Set<String> getTerms() {
        Set<String> terms = new HashSet(Arrays.asList(LRDDTemplateDictionary.terms));
        terms.addAll(super.getTerms());
        return terms;
    }

}