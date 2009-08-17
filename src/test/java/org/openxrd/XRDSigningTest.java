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

package org.openxrd;

import java.security.KeyPair;

import javax.xml.namespace.QName;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.opensaml.xml.io.Marshaller;
import org.opensaml.xml.security.SecurityHelper;
import org.opensaml.xml.security.credential.BasicCredential;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.signature.SignatureConstants;
import org.opensaml.xml.signature.Signer;
import org.opensaml.xml.util.XMLConstants;
import org.openxrd.common.BaseTestCase;
import org.openxrd.common.xml.XRDConstants;
import org.openxrd.xrd.core.XRD;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

/**
 * This isn't a real test case... just a demonstration of how to sign and print an XRD document.
 */
public class XRDSigningTest extends BaseTestCase {

    /**
     * Test XRD building.
     * 
     * @throws Exception
     */
    public void testXRD() throws Exception {
        QName qname = new QName(XRDConstants.XRD_NS, XRD.DEFAULT_ELEMENT_LOCAL_NAME, XRDConstants.XRD_PREFIX);
        XRD xrd = (XRD) buildXMLObject(qname);
        xrd.setID("foo");

        addSignature(xrd);

        Marshaller marshaller = Configuration.getMarshallerFactory().getMarshaller(xrd);
        marshaller.marshall(xrd);

        Signer.signObject(xrd.getSignature());

        printXRD(xrd);
        System.out.println("\n\n");
        printXRD2(xrd);
    }

    /**
     * Sign the XRD.
     * 
     * @param xrd XRD to sign
     */
    public void addSignature(XRD xrd) throws Exception {
        QName qname = new QName(XMLConstants.XMLSIG_NS, Signature.DEFAULT_ELEMENT_LOCAL_NAME,
                XMLConstants.XMLSIG_PREFIX);
        Signature signature = (Signature) buildXMLObject(qname);

        KeyPair keyPair = SecurityHelper.generateKeyPair("RSA", 1024, null);
        BasicCredential credential = SecurityHelper.getSimpleCredential(keyPair.getPublic(), keyPair.getPrivate());
        signature.setSigningCredential(credential);
        signature.setCanonicalizationAlgorithm(SignatureConstants.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
        signature.setSignatureAlgorithm(SignatureConstants.ALGO_ID_SIGNATURE_RSA);

        xrd.setSignature(signature);
    }

    /**
     * Print the XRD using DOM Level 3 serialization.
     * 
     * @param xrd XRD to print
     * @throws Exception if problems occur
     */
    public void printXRD(XRD xrd) throws Exception {

        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");

        LSSerializer writer = impl.createLSSerializer();
        LSOutput output = impl.createLSOutput();
        output.setByteStream(System.out);
        writer.write(xrd.getDOM(), output);
    }

    /**
     * Print the XRD using deprecated Xerces serializer.
     * 
     * @param xrd XRD to print
     * @throws Exception if problems occur
     */
    public void printXRD2(XRD xrd) throws Exception {
        OutputFormat of = new OutputFormat("XML", "ISO-8859-1", true);

        of.setIndent(1);
        of.setIndenting(true);

        XMLSerializer serializer = new XMLSerializer(System.out, of);
        // As a DOM Serializer
        serializer.asDOMSerializer();
        serializer.serialize(xrd.getDOM());
    }
}