
package com.redhat.emea.es.lab.model.dmn.exafeel;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.kie.dmn.feel.lang.FEELProperty;
import org.kie.dmn.feel.lang.FEELType;


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
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="temperatura" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="humedad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "city",
    "temperatura",
    "humedad"
})
@XmlRootElement(name = "DataDmn")
@FEELType
public class DataDmn
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String city;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer temperatura;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer humedad;

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the temperatura property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @FEELProperty("Temp Media")
    public Integer getTemperatura() {
        return temperatura;
    }

    /**
     * Sets the value of the temperatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTemperatura(Integer value) {
        this.temperatura = value;
    }

    /**
     * Gets the value of the humedad property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHumedad() {
        return humedad;
    }

    /**
     * Sets the value of the humedad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHumedad(Integer value) {
        this.humedad = value;
    }

}
