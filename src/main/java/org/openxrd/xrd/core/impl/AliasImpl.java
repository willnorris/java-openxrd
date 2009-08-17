package org.openxrd.xrd.core.impl;

import java.util.List;

import org.opensaml.xml.XMLObject;
import org.openxrd.xrd.common.impl.AbstractXRDObject;
import org.openxrd.xrd.core.Alias;

public class AliasImpl extends AbstractXRDObject implements Alias {

	protected AliasImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
		super(namespaceURI, elementLocalName, namespacePrefix);
	}

	public List<XMLObject> getOrderedChildren() {
		// No elements
		return null;
	}

}