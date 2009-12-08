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

package org.openxrd.template;

import java.util.List;
import java.util.Map;

/**
 * The template manager maintains a registry of URI {@link TemplateDictionary}s associated with rel values. The manager
 * is also responsible for applying templates based on a list of dictionaries and input values.
 */
public interface TemplateManager {

    /**
     * Register a template dictionary with a specified rel value.
     * 
     * @param rel rel value to register dictionary with
     * @param dictionary template dictionary to register
     */
    public void registerDictionary(String rel, TemplateDictionary dictionary);

    /**
     * Get the template dictionaries registered for the specified rel value.
     * 
     * @param rel rel value to get dictionaries for
     * @return list of registered dictionaries
     */
    public List<TemplateDictionary> getDictionaries(String rel);

    /**
     * Populate a template using the specified input values.
     * 
     * @param template template to populate
     * @param input values used to populate the template
     * @return populated template
     * @throws TemplateException if problem occurs while processing the template
     */
    public String applyTemplate(String template, Map<String, String> input) throws TemplateException;

    /**
     * Populate a template using a template dictionary and input string.
     * 
     * @param template template to populate
     * @param dictionary dictionary used to extract values from the input string
     * @param input input string used to populate the template
     * @return populated template
     * @throws TemplateException if problem occurs while processing the template
     */
    public String applyTemplate(String template, TemplateDictionary dictionary, String input) throws TemplateException;

}