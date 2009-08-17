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
import org.openxrd.xrd.core.Expires;

/**
 * Checks {@link Expires} for schema compliance.
 */
public class ExpiresSchemaValidator implements Validator<Expires> {

    /** {@inheritDoc} */
    public void validate(Expires expires) throws ValidationException {
        validateExpires(expires);
    }

    /**
     * Checks that the expires value is specified.
     * 
     * @param expires Expires to validate
     * @throws ValidationException if expires value is not specified
     */
    protected void validateExpires(Expires expires) throws ValidationException {
        if (expires.getValue() == null) {
            throw new ValidationException("Expires value must be specified.");
        }
    }
}
