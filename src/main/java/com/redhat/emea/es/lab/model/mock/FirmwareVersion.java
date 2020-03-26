
package com.redhat.emea.es.lab.model.mock;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="MajorRevision" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MinorRevision" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Major" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Minor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Build" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Revision" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "majorRevision",
    "minorRevision",
    "major",
    "minor",
    "build",
    "revision"
})
@XmlRootElement(name = "FirmwareVersion")
public class FirmwareVersion
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "MajorRevision", required = true, nillable = true)
    protected String majorRevision;
    @XmlElement(name = "MinorRevision", required = true, nillable = true)
    protected String minorRevision;
    @XmlElement(name = "Major", required = true, nillable = true)
    protected String major;
    @XmlElement(name = "Minor", required = true, nillable = true)
    protected String minor;
    @XmlElement(name = "Build", required = true, nillable = true)
    protected String build;
    @XmlElement(name = "Revision", required = true, nillable = true)
    protected String revision;

    /**
     * Gets the value of the majorRevision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajorRevision() {
        return majorRevision;
    }

    /**
     * Sets the value of the majorRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajorRevision(String value) {
        this.majorRevision = value;
    }

    /**
     * Gets the value of the minorRevision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinorRevision() {
        return minorRevision;
    }

    /**
     * Sets the value of the minorRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinorRevision(String value) {
        this.minorRevision = value;
    }

    /**
     * Gets the value of the major property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajor() {
        return major;
    }

    /**
     * Sets the value of the major property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajor(String value) {
        this.major = value;
    }

    /**
     * Gets the value of the minor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinor() {
        return minor;
    }

    /**
     * Sets the value of the minor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinor(String value) {
        this.minor = value;
    }

    /**
     * Gets the value of the build property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuild() {
        return build;
    }

    /**
     * Sets the value of the build property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuild(String value) {
        this.build = value;
    }

    /**
     * Gets the value of the revision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevision() {
        return revision;
    }

    /**
     * Sets the value of the revision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevision(String value) {
        this.revision = value;
    }

}
