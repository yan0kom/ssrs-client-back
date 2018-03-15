
package com.microsoft.sqlserver.ReportExecution2005;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ListSecureMethodsResult" type="{http://schemas.microsoft.com/sqlserver/2005/06/30/reporting/reportingservices}ArrayOfString" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listSecureMethodsResult"
})
@XmlRootElement(name = "ListSecureMethodsResponse")
public class ListSecureMethodsResponse {

    @XmlElement(name = "ListSecureMethodsResult")
    protected ArrayOfString listSecureMethodsResult;

    /**
     * Gets the value of the listSecureMethodsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getListSecureMethodsResult() {
        return listSecureMethodsResult;
    }

    /**
     * Sets the value of the listSecureMethodsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setListSecureMethodsResult(ArrayOfString value) {
        this.listSecureMethodsResult = value;
    }

}
