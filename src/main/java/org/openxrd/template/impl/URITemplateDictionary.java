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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openxrd.template.TemplateDictionary;

/**
 * Template Dictionary which provides RFC3986 URI parts.
 */
public class URITemplateDictionary implements TemplateDictionary {

    private static final String[] terms = { "scheme", "authority", "userinfo", "host", "port", "path", "query",
            "fragment" };

    /** {@inheritDoc} */
    public Map<String, String> getTermValues(String input) {
        try {
            URI uri = new URI(input);
            return getURIParts(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return Collections.EMPTY_MAP;
        }
    }

    protected Map<String, String> getURIParts(URI uri) {
        Map<String, String> values = new HashMap<String, String>();

        if (uri.getScheme() != null) {
            values.put("scheme", uri.getScheme());
        }

        if (uri.getAuthority() != null) {
            values.put("authority", uri.getAuthority());
        }

        if (uri.getUserInfo() != null) {
            values.put("userinfo", uri.getUserInfo());
        }

        if (uri.getHost() != null) {
            values.put("host", uri.getHost());
        }

        if (uri.getPort() != -1) {
            values.put("port", new Integer(uri.getPort()).toString());
        }

        if (uri.getPath() != null) {
            values.put("path", uri.getPath());
        }

        if (uri.getQuery() != null) {
            values.put("query", uri.getQuery());
        }

        if (uri.getFragment() != null) {
            values.put("fragment", uri.getFragment());
        }

        return values;
    }

    /** {@inheritDoc} */
    public Set<String> getTerms() {
        return new HashSet(Arrays.asList(URITemplateDictionary.terms));
    }

}