
package com.redhat.emea.es.lab.model.cep.commerce;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.kie.api.definition.type.Duration;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:com:redhat:emea:es:lab:model:cep:commerce}BaseEvent"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="duration_TS" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="information" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "duration_TS",
    "information"
})
@XmlRootElement(name = "AnIntervalEvent")
@Role(Role.Type.EVENT)
@Timestamp("origen_TS")
@Duration("duration_TS")
public class AnIntervalEvent
    extends BaseEvent
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected long duration_TS;
    @XmlElement(required = true)
    protected String information;

    /**
     * Gets the value of the duration_TS property.
     * 
     */
    public long getDuration_TS() {
        return duration_TS;
    }

    /**
     * Sets the value of the duration_TS property.
     * 
     */
    public void setDuration_TS(long value) {
        this.duration_TS = value;
    }

    /**
     * Gets the value of the information property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformation() {
        return information;
    }

    /**
     * Sets the value of the information property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformation(String value) {
        this.information = value;
    }

}
