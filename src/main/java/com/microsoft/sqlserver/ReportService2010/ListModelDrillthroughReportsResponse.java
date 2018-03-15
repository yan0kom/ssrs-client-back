
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
 *         &lt;element name="Reports" type="{http://schemas.microsoft.com/sqlserver/reporting/2010/03/01/ReportServer}ArrayOfModelDrillthroughReport" minOccurs="0"/&gt;
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
    "reports"
})
@XmlRootElement(name = "ListModelDrillthroughReportsResponse")
public class ListModelDrillthroughReportsResponse {

    @XmlElement(name = "Reports")
    protected ArrayOfModelDrillthroughReport reports;

    /**
     * Gets the value of the reports property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfModelDrillthroughReport }
     *     
     */
    public ArrayOfModelDrillthroughReport getReports() {
        return reports;
    }

    /**
     * Sets the value of the reports property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfModelDrillthroughReport }
     *     
     */
    public void setReports(ArrayOfModelDrillthroughReport value) {
        this.reports = value;
    }

}
