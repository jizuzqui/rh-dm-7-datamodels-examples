
package com.redhat.emea.es.lab.model.cep.commerce;

import java.io.Serializable;
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
 * Base Event :: A CEP example 
 * 
 * <p>Java class for BaseEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseEvent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="eventid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="origen_TS" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="event_TS" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="dateHumanReadable" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseEvent", propOrder = {
    "eventid",
    "origen_TS",
    "event_TS",
    "timestamp",
    "dateHumanReadable"
})
@XmlSeeAlso({
    AnTransactionEvent.class,
    ABoxEvent.class,
    AnIntervalEvent.class
})
public abstract class BaseEvent
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String eventid;
    protected long origen_TS;
    protected long event_TS;
    protected long timestamp;
    @XmlElement(required = true, type = String.class, nillable = true)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected Date dateHumanReadable;

    /**
     * Gets the value of the eventid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventid() {
        return eventid;
    }

    /**
     * Sets the value of the eventid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventid(String value) {
        this.eventid = value;
    }

    /**
     * Gets the value of the origen_TS property.
     * 
     */
    public long getOrigen_TS() {
        return origen_TS;
    }

    /**
     * Sets the value of the origen_TS property.
     * 
     */
    public void setOrigen_TS(long value) {
        this.origen_TS = value;
    }

    /**
     * Gets the value of the event_TS property.
     * 
     */
    public long getEvent_TS() {
        return event_TS;
    }

    /**
     * Sets the value of the event_TS property.
     * 
     */
    public void setEvent_TS(long value) {
        this.event_TS = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     */
    public void setTimestamp(long value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the dateHumanReadable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getDateHumanReadable() {
        return dateHumanReadable;
    }

    /**
     * Sets the value of the dateHumanReadable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateHumanReadable(Date value) {
        this.dateHumanReadable = value;
    }

}
