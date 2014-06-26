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


package org.docx4j.dml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CT_LuminanceEffect complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CT_LuminanceEffect">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="bright" type="{http://schemas.openxmlformats.org/drawingml/2006/main}ST_FixedPercentage" default="0" />
 *       &lt;attribute name="contrast" type="{http://schemas.openxmlformats.org/drawingml/2006/main}ST_FixedPercentage" default="0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_LuminanceEffect")
public class CTLuminanceEffect {

    @XmlAttribute
    protected Integer bright;
    @XmlAttribute
    protected Integer contrast;

    /**
     * Gets the value of the bright property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getBright() {
        if (bright == null) {
            return  0;
        } else {
            return bright;
        }
    }

    /**
     * Sets the value of the bright property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBright(Integer value) {
        this.bright = value;
    }

    /**
     * Gets the value of the contrast property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getContrast() {
        if (contrast == null) {
            return  0;
        } else {
            return contrast;
        }
    }

    /**
     * Sets the value of the contrast property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setContrast(Integer value) {
        this.contrast = value;
    }

}
