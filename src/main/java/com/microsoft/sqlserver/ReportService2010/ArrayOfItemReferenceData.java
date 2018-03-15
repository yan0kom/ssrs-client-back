
package com.microsoft.sqlserver.ReportService2010;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfItemReferenceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfItemReferenceData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ItemReferenceData" type="{http://schemas.microsoft.com/sqlserver/reporting/2010/03/01/ReportServer}ItemReferenceData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfItemReferenceData", propOrder = {
    "itemReferenceData"
})
public class ArrayOfItemReferenceData {

    @XmlElement(name = "ItemReferenceData", nillable = true)
    protected List<ItemReferenceData> itemReferenceData;

    /**
     * Gets the value of the itemReferenceData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemReferenceData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemReferenceData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemReferenceData }
     * 
     * 
     */
    public List<ItemReferenceData> getItemReferenceData() {
        if (itemReferenceData == null) {
            itemReferenceData = new ArrayList<ItemReferenceData>();
        }
        return this.itemReferenceData;
    }

}
