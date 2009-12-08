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
import org.openxrd.xrd.core.Title;

/**
 * Checks {@link Title} for schema compliance.
 */
public class TitleSchemaValidator implements Validator<Title> {

    /** {@inheritDoc} */
    public void validate(Title title) throws ValidationException {
        validateTitle(title);
    }

    /**
     * Checks that the title value is specified.
     * 
     * @param title Title to validate
     * @throws ValidationException if title value is not specified
     */
    protected void validateTitle(Title title) throws ValidationException {
        if (DatatypeHelper.isEmpty(title.getValue())) {
            throw new ValidationException("Title value must be specified.");
        }
    }
}