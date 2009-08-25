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

package org.openxrd.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openxrd.xrd.common.Prioritizable;
import org.openxrd.xrd.common.PrioritizableComparator;
import org.openxrd.xrd.core.Link;

/**
 * Prioritizable tests.
 */
public class PrioritizableTest extends BaseTestCase {

    /**
     * Basic test of priority comparison.
     */
    public void testPriority() {
        List<Prioritizable> items = new ArrayList<Prioritizable>();

        Link link = (Link) buildXMLObject(Link.DEFAULT_ELEMENT_NAME);
        link.setPriority(10);
        items.add(link);

        link = (Link) buildXMLObject(Link.DEFAULT_ELEMENT_NAME);
        link.setPriority(15);
        items.add(link);

        link = (Link) buildXMLObject(Link.DEFAULT_ELEMENT_NAME);
        link.setPriority(5);
        items.add(link);

        Comparator comparator = new PrioritizableComparator();
        Collections.sort(items, comparator);

        assertEquals(3, items.size());
        assertEquals(Integer.valueOf(5), items.get(0).getPriority());
        assertEquals(Integer.valueOf(10), items.get(1).getPriority());
        assertEquals(Integer.valueOf(15), items.get(2).getPriority());
    }

}