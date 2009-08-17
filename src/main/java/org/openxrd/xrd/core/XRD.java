package org.openxrd.xrd.core;

import java.util.List;

import org.openxrd.xrd.common.XRDObject;

public interface XRD extends XRDObject {

	public Expires getExpires();
	
	public Subject getSubject();
	
	public List<Alias> getAliases();
	
	public List<Type> getTypes();
	
	public List<Link> getLinks();
}
