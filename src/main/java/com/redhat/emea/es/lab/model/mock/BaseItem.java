
package com.redhat.emea.es.lab.model.mock;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.redhat.emea.es.lab.model.adapter.LocalDateTimeAdapter;


/**
 * BaseItem :: Item
 * 
 * <p>Java class for BaseItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idLocal" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="idItem" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="modified" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="totalf" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="totalD" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="totalde" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="years" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="yearsS" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="yearsB" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseItem", propOrder = {
    "id",
    "idLocal",
    "idItem",
    "created",
    "modified",
    "owner",
    "active",
    "totalf",
    "totalD",
    "totalde",
    "years",
    "yearsS",
    "yearsB"
})
@XmlSeeAlso({
    Contract.class
})
public abstract class BaseItem
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true, nillable = true)
    protected BigInteger idLocal;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long idItem;
    @XmlElement(required = true, type = String.class, nillable = true)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected Date created;
    @XmlElement(required = true, type = String.class, nillable = true)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected Date modified;
    @XmlElement(required = true, nillable = true)
    protected String owner;
    @XmlElement(required = true, type = Boolean.class, defaultValue = "true", nillable = true)
    protected Boolean active;
    @XmlElement(required = true, type = Float.class, defaultValue = "0.0", nillable = true)
    protected Float totalf;
    @XmlElement(required = true, type = Double.class, defaultValue = "0.0", nillable = true)
    protected Double totalD;
    @XmlElement(required = true, defaultValue = "0.0", nillable = true)
    protected BigDecimal totalde;
    @XmlElement(required = true, type = Integer.class, defaultValue = "0", nillable = true)
    protected Integer years;
    @XmlElement(required = true, type = Short.class, defaultValue = "0", nillable = true)
    protected Short yearsS;
    @XmlElement(required = true, type = Byte.class, defaultValue = "0", nillable = true)
    protected Byte yearsB;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the idLocal property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdLocal() {
        return idLocal;
    }

    /**
     * Sets the value of the idLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdLocal(BigInteger value) {
        this.idLocal = value;
    }

    /**
     * Gets the value of the idItem property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdItem() {
        return idItem;
    }

    /**
     * Sets the value of the idItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdItem(Long value) {
        this.idItem = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreated(Date value) {
        this.created = value;
    }

    /**
     * Gets the value of the modified property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getModified() {
        return modified;
    }

    /**
     * Sets the value of the modified property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModified(Date value) {
        this.modified = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the totalf property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTotalf() {
        return totalf;
    }

    /**
     * Sets the value of the totalf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTotalf(Float value) {
        this.totalf = value;
    }

    /**
     * Gets the value of the totalD property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalD() {
        return totalD;
    }

    /**
     * Sets the value of the totalD property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalD(Double value) {
        this.totalD = value;
    }

    /**
     * Gets the value of the totalde property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalde() {
        return totalde;
    }

    /**
     * Sets the value of the totalde property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalde(BigDecimal value) {
        this.totalde = value;
    }

    /**
     * Gets the value of the years property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYears() {
        return years;
    }

    /**
     * Sets the value of the years property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYears(Integer value) {
        this.years = value;
    }

    /**
     * Gets the value of the yearsS property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getYearsS() {
        return yearsS;
    }

    /**
     * Sets the value of the yearsS property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setYearsS(Short value) {
        this.yearsS = value;
    }

    /**
     * Gets the value of the yearsB property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getYearsB() {
        return yearsB;
    }

    /**
     * Sets the value of the yearsB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setYearsB(Byte value) {
        this.yearsB = value;
    }

}
