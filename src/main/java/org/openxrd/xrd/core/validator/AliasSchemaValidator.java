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

import org.opensaml.xml.util.DatatypeHelper;
import org.opensaml.xml.validation.ValidationException;
import org.opensaml.xml.validation.Validator;
import org.openxrd.xrd.core.Alias;

/**
 * Checks {@link Alias} for schema compliance.
 */
public class AliasSchemaValidator implements Validator<Alias> {

    /** {@inheritDoc} */
    public void validate(Alias alias) throws ValidationException {
        validateAlias(alias);
    }

    /**
     * Checks that the alias value is specified.
     * 
     * @param alias Alias to validate
     * @throws ValidationException if alias value is not specified
     */
    protected void validateAlias(Alias alias) throws ValidationException {
        if (DatatypeHelper.isEmpty(alias.getValue())) {
            throw new ValidationException("Alias value must be specified.");
        }
    }

}