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

import junit.framework.TestCase;

import org.openxrd.template.impl.BasicTemplateManager;
import org.openxrd.template.impl.LRDDTemplateDictionary;

/**
 * Basic Template tests.
 */
public class TemplateTest extends TestCase {

    public void testTemplate() {
        TemplateManager manager = new BasicTemplateManager();
        TemplateDictionary dictionary = new LRDDTemplateDictionary();
        
        String template = "http://example.com/?uri={%uri}";
        String input = "http://openxrd.org/";
        String result = manager.applyTemplate(template, dictionary, input);        
        assertEquals("http://example.com/?uri=http%3A%2F%2Fopenxrd.org%2F", result);
    }
    
}