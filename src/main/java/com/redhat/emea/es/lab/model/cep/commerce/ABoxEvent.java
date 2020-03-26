
package com.redhat.emea.es.lab.model.cep.commerce;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.kie.api.definition.type.Role;


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
 *         &lt;element name="machineid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="box" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="totalbox" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "machineid",
    "box",
    "totalbox",
    "status"
})
@XmlRootElement(name = "ABoxEvent")
@Role(Role.Type.EVENT)
public class ABoxEvent
    extends BaseEvent
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String machineid;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer box;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer totalbox;
    @XmlElement(required = true)
    protected String status;

    /**
     * Gets the value of the machineid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMachineid() {
        return machineid;
    }

    /**
     * Sets the value of the machineid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMachineid(String value) {
        this.machineid = value;
    }

    /**
     * Gets the value of the box property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBox() {
        return box;
    }

    /**
     * Sets the value of the box property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBox(Integer value) {
        this.box = value;
    }

    /**
     * Gets the value of the totalbox property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalbox() {
        return totalbox;
    }

    /**
     * Sets the value of the totalbox property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalbox(Integer value) {
        this.totalbox = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
