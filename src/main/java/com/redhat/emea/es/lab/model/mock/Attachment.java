
package com.redhat.emea.es.lab.model.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="dataHandler" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="hexDataHandler" type="{http://www.w3.org/2001/XMLSchema}hexBinary"/&gt;
 *         &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="originalName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{urn:com:redhat:emea:es:lab:model:mock}Data" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "dataHandler",
    "hexDataHandler",
    "mimeType",
    "originalName",
    "data"
})
@XmlRootElement(name = "Attachment")
public abstract class Attachment
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected byte[] dataHandler;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] hexDataHandler;
    @XmlElement(required = true, nillable = true)
    protected String mimeType;
    @XmlElement(required = true, nillable = true)
    protected String originalName;
    @XmlElement(name = "Data")
    protected List<Data> data;

    /**
     * Gets the value of the dataHandler property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDataHandler() {
        return dataHandler;
    }

    /**
     * Sets the value of the dataHandler property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDataHandler(byte[] value) {
        this.dataHandler = value;
    }

    /**
     * Gets the value of the hexDataHandler property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getHexDataHandler() {
        return hexDataHandler;
    }

    /**
     * Sets the value of the hexDataHandler property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHexDataHandler(byte[] value) {
        this.hexDataHandler = value;
    }

    /**
     * Gets the value of the mimeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Sets the value of the mimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMimeType(String value) {
        this.mimeType = value;
    }

    /**
     * Gets the value of the originalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * Sets the value of the originalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalName(String value) {
        this.originalName = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the data property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data }
     * 
     * 
     */
    public List<Data> getData() {
        if (data == null) {
            data = new ArrayList<Data>();
        }
        return this.data;
    }

}
