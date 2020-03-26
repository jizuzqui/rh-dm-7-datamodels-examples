
package com.redhat.emea.es.lab.model.mock;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Base Aggregate :: Aggregate
 * 
 * <p>Java class for BaseAggregate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseAggregate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="closeTimeTS" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="aggregateJackpot" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseAggregate", propOrder = {
    "closeTimeTS",
    "aggregateJackpot"
})
@XmlSeeAlso({
    AggregateDay.class
})
public abstract class BaseAggregate
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long closeTimeTS;
    @XmlElement(required = true, type = Float.class, nillable = true)
    protected Float aggregateJackpot;

    /**
     * Gets the value of the closeTimeTS property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCloseTimeTS() {
        return closeTimeTS;
    }

    /**
     * Sets the value of the closeTimeTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCloseTimeTS(Long value) {
        this.closeTimeTS = value;
    }

    /**
     * Gets the value of the aggregateJackpot property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getAggregateJackpot() {
        return aggregateJackpot;
    }

    /**
     * Sets the value of the aggregateJackpot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setAggregateJackpot(Float value) {
        this.aggregateJackpot = value;
    }

}
