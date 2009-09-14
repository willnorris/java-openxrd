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

package org.openxrd.common;

import org.opensaml.xml.util.XMLConstants;

/**
 * XML related constants used in the XRD specification.
 */
public class XRDConstants extends XMLConstants {

    /** Directory, on the classpath, schemas are located in. */
    public static final String SCHEMA_DIR = "/schema/";

    /** XRD 1.0 Schema location. */
    public static final String XRD_SCHEMA_LOCATION = SCHEMA_DIR + "xrd-1.0.xsd";

    /** XRD 1.0 XML Namespace. */
    public static final String XRD_NS = "http://docs.oasis-open.org/ns/xri/xrd-1.0";

    /** XRD 1.0 QName prefix. */
    public static final String XRD_PREFIX = "xrd";

    /** XRD 1.0 Link Rel see-also. */
    public static final String XRD_REL_SEEALSO = "http://docs.oasis-open.org/xri/xrd/v1.0#see-also";
    
    /** XRD 1.0 Mime-Type. */
    public static final String XRD_MIME_TYPE = "application/xrd+xml";
    
    /** XRD 1.0 describedby rel value. */
    public static final String XRD_REL_DESCRIBEDBY = "describedby";

}