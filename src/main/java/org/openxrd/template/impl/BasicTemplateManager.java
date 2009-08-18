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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openxrd.template.TemplateDictionary;
import org.openxrd.template.TemplateManager;

/**
 * Basic implementation of TemplateManager.
 */
public class BasicTemplateManager implements TemplateManager {

    /** Dictionary registry. */
    private Map<String, List<TemplateDictionary>> dictionaries;

    /** {@inheritDoc} */
    public String applyTemplate(String template, TemplateDictionary dictionary, String input) {
        Map<String, String> terms = dictionary.getTermValues(input);
        return applyTemplate(template, terms);
    }

    /** {@inheritDoc} */
    public String applyTemplate(String template, Map<String, String> input) {
        StringBuffer result = new StringBuffer();

        Pattern termPattern = Pattern.compile("\\{%?(.+)\\}");
        Matcher matcher = termPattern.matcher(template);

        while (matcher.find()) {
            String term = matcher.group(1);
            String value;

            if (input.containsKey(term)) {
                value = input.get(term);
            } else {
                value = "";
            }

            if (matcher.group().charAt(1) == '%') {
                try {
                    value = URLEncoder.encode(value, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            matcher.appendReplacement(result, value);
        }

        matcher.appendTail(result);
        return result.toString();
    }

    /** {@inheritDoc} */
    public List<TemplateDictionary> getDictionaries(String rel) {
        if (dictionaries.containsKey(rel)) {
            return dictionaries.get(rel);
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    /** {@inheritDoc} */
    public void registerDictionary(String rel, TemplateDictionary dictionary) {
        if (!dictionaries.containsKey(rel)) {
            dictionaries.put(rel, new ArrayList<TemplateDictionary>());
        }

        if (!dictionaries.get(rel).contains(dictionary)) {
            dictionaries.get(rel).add(dictionary);
        }
    }

}
