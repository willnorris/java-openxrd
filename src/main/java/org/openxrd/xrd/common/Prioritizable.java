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
 * Prioritizable objects have an Integer priority which can be used to sort a list of such objects. The comparison rules
 * for the priorities of two objects is defined in XRD 1.0.
 * 
 * @see http://docs.oasis-open.org/xri/xrd/v1.0/xrd-1.0.html#s.priority.attribute
 */
public interface Prioritizable {

    /**
     * Get the priority.
     * 
     * @return the priority
     */
    public Integer getPriority();

}