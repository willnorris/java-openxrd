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

package org.openxrd.xrd.core.impl;

import org.opensaml.xml.XMLObject;
import org.openxrd.xrd.common.impl.AbstractExtensibleXRDObjectUnmarshaller;
import org.openxrd.xrd.core.Subject;

/**
 * A thread-safe Unmarshaller for {@link Subject}.
 */
public class SubjectUnmarshaller extends AbstractExtensibleXRDObjectUnmarshaller {

    /** {@inheritDoc} */
    protected void processElementContent(XMLObject xmlObject, String elementContent) {
        Subject subject = (Subject) xmlObject;

        subject.setValue(elementContent);
    }

}