
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
 *         &lt;element name="DataSettings" type="{http://schemas.microsoft.com/sqlserver/reporting/2010/03/01/ReportServer}DataSetDefinition" minOccurs="0"/&gt;
 *         &lt;element name="Changed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="ParameterNames" type="{http://schemas.microsoft.com/sqlserver/reporting/2010/03/01/ReportServer}ArrayOfString1" minOccurs="0"/&gt;
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
    "dataSettings",
    "changed",
    "parameterNames"
})
@XmlRootElement(name = "PrepareQueryResponse")
public class PrepareQueryResponse {

    @XmlElement(name = "DataSettings")
    protected DataSetDefinition dataSettings;
    @XmlElement(name = "Changed")
    protected boolean changed;
    @XmlElement(name = "ParameterNames")
    protected ArrayOfString1 parameterNames;

    /**
     * Gets the value of the dataSettings property.
     * 
     * @return
     *     possible object is
     *     {@link DataSetDefinition }
     *     
     */
    public DataSetDefinition getDataSettings() {
        return dataSettings;
    }

    /**
     * Sets the value of the dataSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSetDefinition }
     *     
     */
    public void setDataSettings(DataSetDefinition value) {
        this.dataSettings = value;
    }

    /**
     * Gets the value of the changed property.
     * 
     */
    public boolean isChanged() {
        return changed;
    }

    /**
     * Sets the value of the changed property.
     * 
     */
    public void setChanged(boolean value) {
        this.changed = value;
    }

    /**
     * Gets the value of the parameterNames property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString1 }
     *     
     */
    public ArrayOfString1 getParameterNames() {
        return parameterNames;
    }

    /**
     * Sets the value of the parameterNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString1 }
     *     
     */
    public void setParameterNames(ArrayOfString1 value) {
        this.parameterNames = value;
    }

}
