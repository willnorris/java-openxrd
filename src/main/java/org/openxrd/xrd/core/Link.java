package org.openxrd.xrd.core;

import java.util.List;

import org.openxrd.xrd.common.XRDObject;

public interface Link extends XRDObject {

	public int getPriority();
	
	public List<Rel> getRels();
	
	public List<MediaType> getMediaTypes();
	
	public List<URI> getURIs();
	
	public List<URITemplate> getURITemplates();
	
	public LinkSubject getLinkSubject();
	
	public LocalID getLocalID();
}
