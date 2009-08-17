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

package org.openxrd.xrd.core.validator;

import org.opensaml.xml.validation.ValidationException;
import org.opensaml.xml.validation.Validator;
import org.openxrd.xrd.core.XRD;

/**
 * Checks {@link XRD} for schema compliance.
 */
public class XRDSchemaValidator implements Validator<XRD> {

    /** {@inheritDoc} */
    public void validate(XRD xrd) throws ValidationException {
        validateSubject(xrd);
    }

    /**
     * Checks that the Subject is present.
     * 
     * @param xrd XRD to validate
     * @throws ValidationException if subject is not present
     */
    protected void validateSubject(XRD xrd) throws ValidationException {
        if (xrd.getSubject() == null) {
            throw new ValidationException("Subject is required.");
        }
    }
}