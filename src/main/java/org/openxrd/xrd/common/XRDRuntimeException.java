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
 * Base class for XRD runtime exceptions.
 */
public class XRDRuntimeException extends RuntimeException {

    /** Serial Version UID. */
    private static final long serialVersionUID = 8871175904389536088L;

    /** Constructor. */
    public XRDRuntimeException() {
        super();
    }

    /**
     * Constructor.
     * 
     * @param message exception message
     * @param cause exception to be wrapped by this one
     */
    public XRDRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor.
     * 
     * @param message exception message
     */
    public XRDRuntimeException(String message) {
        super(message);
    }

    /**
     * Constructor.
     * 
     * @param cause exception to be wrapped by this one
     */
    public XRDRuntimeException(Throwable cause) {
        super(cause);
    }

}