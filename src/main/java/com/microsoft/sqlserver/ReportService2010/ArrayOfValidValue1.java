
package com.microsoft.sqlserver.ReportService2010;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfValidValue1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfValidValue1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ValidValue" type="{http://schemas.microsoft.com/sqlserver/reporting/2010/03/01/ReportServer}ValidValue" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfValidValue1", propOrder = {
    "validValue"
})
public class ArrayOfValidValue1 {

    @XmlElement(name = "ValidValue", nillable = true)
    protected List<ValidValue> validValue;

    /**
     * Gets the value of the validValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValidValue }
     * 
     * 
     */
    public List<ValidValue> getValidValue() {
        if (validValue == null) {
            validValue = new ArrayList<ValidValue>();
        }
        return this.validValue;
    }

}
