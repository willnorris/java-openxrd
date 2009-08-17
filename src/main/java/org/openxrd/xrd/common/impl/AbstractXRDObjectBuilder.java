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
package org.openxrd.xrd.common.impl;

import org.opensaml.xml.AbstractXMLObjectBuilder;
import org.openxrd.xrd.common.XRDObject;
import org.openxrd.xrd.common.XRDObjectBuilder;

/**
 * Base builder for {@link XRDObject}s.
 *
 * @param <XRDObjectType> the XRD Object type to build
 */
public abstract class AbstractXRDObjectBuilder<XRDObjectType extends XRDObject> extends
        AbstractXMLObjectBuilder<XRDObjectType> implements XRDObjectBuilder<XRDObjectType> {

    /**
     * Builds a XRDObject using the default name and namespace information provided XRD specifications.
     * 
     * @return built XRDObject
     */
    public abstract XRDObjectType buildObject();
}