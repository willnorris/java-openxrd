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
import org.openxrd.xrd.core.URITemplate;

/**
 * Checks {@link URITemplate} for schema compliance.
 */
public class URITemplateSchemaValidator implements Validator<URITemplate> {

    /** {@inheritDoc} */
    public void validate(URITemplate uri) throws ValidationException {
        validateURI(uri);
    }

    /**
     * Checks that the uri template value is specified.
     * 
     * @param uri URITemplate to validate
     * @throws ValidationException if uri template value is not specified
     */
    protected void validateURI(URITemplate uri) throws ValidationException {
        if (DatatypeHelper.isEmpty(uri.getValue())) {
            throw new ValidationException("URITemplate value must be specified.");
        }
    }

}