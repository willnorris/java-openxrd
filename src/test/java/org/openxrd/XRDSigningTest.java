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

import org.opensaml.xml.security.SecurityHelper;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.signature.Signer;
import org.opensaml.xml.util.XMLHelper;
import org.openxrd.common.BaseTestCase;
import org.openxrd.xrd.core.XRD;

/**
 * This isn't a real test case... just a demonstration of how to sign and print an XRD document.
 */
public class XRDSigningTest extends BaseTestCase {

    /**
     * Test XRD building.
     * 
     * @throws Exception if something breaks
     */
    public void testXRD() throws Exception {
        XRD xrd = (XRD) unmarshallElement("/data/org/openxrd/signing-example.xml");
                
        addSignature(xrd);

        Configuration.getMarshallerFactory().getMarshaller(xrd).marshall(xrd);
        Signer.signObject(xrd.getSignature());

        System.out.println(XMLHelper.nodeToString(xrd.getDOM()));
    }

    /**
     * Sign the XRD.
     * 
     * @param xrd XRD to sign
     * @throws Exception if something breaks
     */
    public void addSignature(XRD xrd) throws Exception {
        Signature signature = (Signature) buildXMLObject(Signature.DEFAULT_ELEMENT_NAME);

        Credential credential = getCredential();
        signature.setSigningCredential(credential);

        SecurityHelper.prepareSignatureParams(signature, credential, null, null);
        xrd.setSignature(signature);
    }

    /**
     * Get a credential to use for signing.
     * 
     * @return a credential for signing
     * @throws Exception if something breaks
     */
    public Credential getCredential() throws Exception {

        KeyPair keyPair = SecurityHelper.generateKeyPair("RSA", 1024, null);
        return SecurityHelper.getSimpleCredential(keyPair.getPublic(), keyPair.getPrivate());

    }
}