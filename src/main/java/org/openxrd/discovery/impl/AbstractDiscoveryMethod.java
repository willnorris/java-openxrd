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

package org.openxrd.discovery.impl;

import java.io.StringReader;
import java.net.URI;

import org.opensaml.xml.io.Unmarshaller;
import org.opensaml.xml.io.UnmarshallingException;
import org.opensaml.xml.parse.ParserPool;
import org.opensaml.xml.parse.XMLParserException;
import org.openxrd.Configuration;
import org.openxrd.discovery.DiscoveryException;
import org.openxrd.discovery.DiscoveryMethod;
import org.openxrd.xrd.core.XRD;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Abstract base DiscoveryMethod implementation.
 */
public abstract class AbstractDiscoveryMethod implements DiscoveryMethod {

    /** Parser Pool. */
    private ParserPool parserPool;

    /** {@inheritDoc} */
    public ParserPool getParserPool() {
        return parserPool;
    }

    /** {@inheritDoc} */
    public void setParserPool(ParserPool newParserPool) {
        parserPool = newParserPool;
    }

    /** {@inheritDoc} */
    public XRD discoverXRD(URI uri) throws DiscoveryException {

        try {
            String xrdContent = getXRDContent(uri);
            Document doc = getParserPool().parse(new StringReader(xrdContent));
            Element element = doc.getDocumentElement();

            Unmarshaller unmarshaller = Configuration.getUnmarshallerFactory().getUnmarshaller(element);
            if (unmarshaller == null) {
                throw new DiscoveryException("Unable to find unmarshaller for element: " + element.toString());
            }

            return (XRD) unmarshaller.unmarshall(element);
        } catch (DiscoveryException e) {
            throw new DiscoveryException("Unable to discover XRD document for uri: " + uri.toString(), e);
        } catch (XMLParserException e) {
            throw new DiscoveryException(e);
        } catch (UnmarshallingException e) {
            throw new DiscoveryException(e);
        }

    }

    /**
     * Get the string content of the XRD document.
     * 
     * @param uri URI to retrieve content for
     * @return content of the XRD document.
     * @throws DiscoveryException if unable to get XRD content
     */
    public abstract String getXRDContent(URI uri) throws DiscoveryException;

}