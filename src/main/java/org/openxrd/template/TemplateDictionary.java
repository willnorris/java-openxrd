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

import java.util.Map;
import java.util.Set;

/**
 * A TemplateDictionary defines a set of terms which may be used in a template. It is also responsible for parsing input
 * strings into variable values to be inserted into a template.
 */
public interface TemplateDictionary {

    /**
     * Get the set of terms that are included in the dictionary.
     * 
     * @return the set of terms that are included in the dictionary
     */
    public Set<String> getTerms();

    /**
     * Get a map of term values for the given input.
     * 
     * @param input string which can be parsed by this dictionary into individual components
     * @return map of term values for the given input
     */
    public Map<String, String> getTermValues(String input);

}