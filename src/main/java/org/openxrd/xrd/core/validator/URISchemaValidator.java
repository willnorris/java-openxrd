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
import org.openxrd.xrd.core.URI;

/**
 * Checks {@link URI} for schema compliance.
 */
public class URISchemaValidator implements Validator<URI> {

    /** {@inheritDoc} */
    public void validate(URI uri) throws ValidationException {
        validatePriority(uri);
    }

    /**
     * Checks that the uri value is specified.
     * 
     * @param uri URI to validate
     * @throws ValidationException if uri value is not specified
     */
    protected void validateURI(URI uri) throws ValidationException {
        if (DatatypeHelper.isEmpty(uri.getValue())) {
            throw new ValidationException("URI value must be specified.");
        }
    }

    /**
     * Checks that the uri priority is non-negative.
     * 
     * @param uri URI to validate
     * @throws ValidationException if uri priority is negative
     */
    protected void validatePriority(URI uri) throws ValidationException {
        if (uri.getPriority() != null && uri.getPriority() < 0) {
            throw new ValidationException("URI priority must be non-negative.");
        }
    }

}