package org.openxrd.xrd.common;

import org.opensaml.xml.XMLObjectBuilder;

public interface XRDObjectBuilder<XRDObjectType extends XRDObject> extends
		XMLObjectBuilder<XRDObjectType> {

	/**
	 * Builds a XRDObject using the default name and namespace information
	 * provided XRD specifications.
	 * 
	 * @return built XRDObject
	 */
	public abstract XRDObjectType buildObject();
}
