package org.openxrd.xrd.common.impl;

import org.opensaml.xml.AbstractXMLObjectBuilder;
import org.openxrd.xrd.common.XRDObject;
import org.openxrd.xrd.common.XRDObjectBuilder;

public abstract class AbstractXRDObjectBuilder<XRDObjectType extends XRDObject> extends
		AbstractXMLObjectBuilder<XRDObjectType> implements XRDObjectBuilder<XRDObjectType> {

    /**
     * Builds a XRDObject using the default name and namespace information provided XRD specifications.
     * 
     * @return built XRDObject
     */
    public abstract XRDObjectType buildObject();
}