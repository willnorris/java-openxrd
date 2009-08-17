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
import org.openxrd.xrd.core.MediaType;

/**
 * Checks {@link MediaType} for schema compliance.
 */
public class MediaTypeSchemaValidator implements Validator<MediaType> {

    /** {@inheritDoc} */
    public void validate(MediaType mediaType) throws ValidationException {
        validateMediaType(mediaType);
    }

    /**
     * Checks that the media-type value is specified.
     * 
     * @param mediaType MediaType to validate
     * @throws ValidationException if media-type value is not specified
     */
    protected void validateMediaType(MediaType mediaType) throws ValidationException {
        if (DatatypeHelper.isEmpty(mediaType.getValue())) {
            throw new ValidationException("MediaType value must be specified.");
        }
    }
}