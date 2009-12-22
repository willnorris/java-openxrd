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

import org.opensaml.xml.signature.SignableXMLObject;

/**
 * A signable XRDObject.
 */
public interface SignableXRDObject extends XRDObject, SignableXMLObject {

    /**
     * Gets the value of the ID attribute for this XRD object which will be used as its signature reference.
     * 
     * @return the value of this XRDObject ID attribute
     */
    public String getSignatureReferenceID();
}