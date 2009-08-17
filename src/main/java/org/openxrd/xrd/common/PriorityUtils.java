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

/**
 *
 */
public class PriorityUtils {

    /**
     * Compare two priorities based on the rules of XRD 1.0. This will correctly handle the case of null priority values
     * (equal to infinity) as well as randomly sorting equal priorities.
     * 
     * @param a first priority to compare
     * @param b second priority to compare
     * @return a negative integer or a positive integer as this object is less than, or greater than the specified
     *         object. If the objects are equivalent, a random positive or negative integer will be returned
     */
    public static int comparePriority(Integer a, Integer b) {
        Integer result;

        // handle the null case
        if (a == null) {
            if (b == null) {
                result = 0;
            } else {
                result = 1;
            }
        } else if (b == null) {
            result = -1;
        } else {
            result = a.compareTo(b);
        }

        // randomize equivalent values
        if (result == 0) {
            Double random = (Math.random() * 10) - 5;
            result = random.intValue();
        }

        return result;
    }

}