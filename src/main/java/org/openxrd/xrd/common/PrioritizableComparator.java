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

package org.openxrd.xrd.common;

import java.util.Comparator;

/**
 * Priority Utils.
 */
public class PrioritizableComparator implements Comparator<Prioritizable> {

    /** {@inheritDoc} */
    public int compare(Prioritizable o1, Prioritizable o2) {
        Integer result;

        // handle the null case
        if (o1.getPriority() == null) {
            if (o2.getPriority() == null) {
                result = 0;
            } else {
                result = 1;
            }
        } else if (o2.getPriority() == null) {
            result = -1;
        } else {
            result = o1.getPriority().compareTo(o2.getPriority());
        }

        // randomize equivalent values
        if (result == 0) {
            Double random = (Math.random() * 10) - 5;
            result = random.intValue();
        }

        return result;
    }

}