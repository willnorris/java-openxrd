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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.opensaml.xml.util.LazyMap;
import org.openxrd.template.TemplateDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Template Dictionary which provides RFC3986 URI parts.
 */
public class URITemplateDictionary implements TemplateDictionary {

    /** Terms supported by this dictionary. */
    private static final String[] TERMS = { "scheme", "authority", "userinfo", "host", "port", "path", "query",
            "fragment", };

    /** Logger. */
    private Logger log = LoggerFactory.getLogger(URITemplateDictionary.class);

    /** {@inheritDoc} */
    public Map<String, String> getTermValues(String input) {
        try {
            URI uri = new URI(input);
            return getURIParts(uri);
        } catch (URISyntaxException e) {
            log.error("Input is not a valid URI: %s", input);
            return Collections.EMPTY_MAP;
        }
    }

    /**
     * Parse the URI and get RFC3986 parts.
     * 
     * @param uri URI to parse
     * @return map of URI parts
     */
    protected Map<String, String> getURIParts(URI uri) {
        Map<String, String> values = new LazyMap<String, String>();

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
        return new HashSet(Arrays.asList(URITemplateDictionary.TERMS));
    }

}