/*
 *  Copyright 2007-2008, Plutext Pty Ltd.
 *   
 *  This file is part of docx4j.

    docx4j is licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 

    You may obtain a copy of the License at 

        http://www.apache.org/licenses/LICENSE-2.0 

    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

 */


package org.docx4j.dml.diagram;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ST_AnimOneStr.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ST_AnimOneStr">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="one"/>
 *     &lt;enumeration value="branch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ST_AnimOneStr")
@XmlEnum
public enum STAnimOneStr {


    /**
     * Disable One-by-One
     * 
     */
    @XmlEnumValue("none")
    NONE("none"),

    /**
     * One By One
     * 
     */
    @XmlEnumValue("one")
    ONE("one"),

    /**
     * By Branch One By One
     * 
     */
    @XmlEnumValue("branch")
    BRANCH("branch");
    private final String value;

    STAnimOneStr(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static STAnimOneStr fromValue(String v) {
        for (STAnimOneStr c: STAnimOneStr.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
