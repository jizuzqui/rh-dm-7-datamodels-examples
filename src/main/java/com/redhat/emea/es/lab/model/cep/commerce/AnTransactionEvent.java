
package com.redhat.emea.es.lab.model.cep.commerce;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.redhat.emea.es.lab.model.adapter.LocalDateTimeAdapter;
import org.kie.api.definition.type.Expires;
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
 *         &lt;element name="commerceid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tpv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="creditcard" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="paymentgateway" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="paymentdatefromcommerce" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="paymentpin" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="paymentmode" type="{urn:com:redhat:emea:es:lab:model:cep:commerce}PaymentMode"/&gt;
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
    "commerceid",
    "tpv",
    "creditcard",
    "paymentgateway",
    "paymentdatefromcommerce",
    "paymentpin",
    "paymentmode"
})
@XmlRootElement(name = "AnTransactionEvent")
@Role(Role.Type.EVENT)
@Timestamp("origen_TS")
@Expires(value = "0s", policy = Expires.Policy.TIME_HARD)
public class AnTransactionEvent
    extends BaseEvent
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String commerceid;
    @XmlElement(required = true, nillable = true)
    protected String tpv;
    @XmlElement(required = true, nillable = true)
    protected String creditcard;
    @XmlElement(required = true, nillable = true)
    protected String paymentgateway;
    @XmlElement(required = true, type = String.class, nillable = true)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected Date paymentdatefromcommerce;
    @XmlElement(required = true, type = Boolean.class, defaultValue = "false", nillable = true)
    protected Boolean paymentpin;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PaymentMode paymentmode;

    /**
     * Gets the value of the commerceid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommerceid() {
        return commerceid;
    }

    /**
     * Sets the value of the commerceid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommerceid(String value) {
        this.commerceid = value;
    }

    /**
     * Gets the value of the tpv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpv() {
        return tpv;
    }

    /**
     * Sets the value of the tpv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpv(String value) {
        this.tpv = value;
    }

    /**
     * Gets the value of the creditcard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditcard() {
        return creditcard;
    }

    /**
     * Sets the value of the creditcard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditcard(String value) {
        this.creditcard = value;
    }

    /**
     * Gets the value of the paymentgateway property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentgateway() {
        return paymentgateway;
    }

    /**
     * Sets the value of the paymentgateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentgateway(String value) {
        this.paymentgateway = value;
    }

    /**
     * Gets the value of the paymentdatefromcommerce property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getPaymentdatefromcommerce() {
        return paymentdatefromcommerce;
    }

    /**
     * Sets the value of the paymentdatefromcommerce property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentdatefromcommerce(Date value) {
        this.paymentdatefromcommerce = value;
    }

    /**
     * Gets the value of the paymentpin property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getPaymentpin() {
        return paymentpin;
    }

    /**
     * Sets the value of the paymentpin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPaymentpin(Boolean value) {
        this.paymentpin = value;
    }

    /**
     * Gets the value of the paymentmode property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMode }
     *     
     */
    public PaymentMode getPaymentmode() {
        return paymentmode;
    }

    /**
     * Sets the value of the paymentmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMode }
     *     
     */
    public void setPaymentmode(PaymentMode value) {
        this.paymentmode = value;
    }

}
