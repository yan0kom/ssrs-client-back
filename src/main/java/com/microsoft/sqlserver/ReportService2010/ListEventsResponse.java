
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
 *         &lt;element name="Events" type="{http://schemas.microsoft.com/sqlserver/reporting/2010/03/01/ReportServer}ArrayOfEvent" minOccurs="0"/&gt;
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
    "events"
})
@XmlRootElement(name = "ListEventsResponse")
public class ListEventsResponse {

    @XmlElement(name = "Events")
    protected ArrayOfEvent events;

    /**
     * Gets the value of the events property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEvent }
     *     
     */
    public ArrayOfEvent getEvents() {
        return events;
    }

    /**
     * Sets the value of the events property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEvent }
     *     
     */
    public void setEvents(ArrayOfEvent value) {
        this.events = value;
    }

}
