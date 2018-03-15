
package com.microsoft.sqlserver.ReportService2010;

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
 *         &lt;element name="Permissions" type="{http://schemas.microsoft.com/sqlserver/reporting/2010/03/01/ReportServer}ArrayOfString3" minOccurs="0"/&gt;
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
    "permissions"
})
@XmlRootElement(name = "GetSystemPermissionsResponse")
public class GetSystemPermissionsResponse {

    @XmlElement(name = "Permissions")
    protected ArrayOfString3 permissions;

    /**
     * Gets the value of the permissions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString3 }
     *     
     */
    public ArrayOfString3 getPermissions() {
        return permissions;
    }

    /**
     * Sets the value of the permissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString3 }
     *     
     */
    public void setPermissions(ArrayOfString3 value) {
        this.permissions = value;
    }

}
