
package com.redhat.emea.es.lab.model.cep.commerce;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentMode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CONTACTLESS"/&gt;
 *     &lt;enumeration value="MOBILE"/&gt;
 *     &lt;enumeration value="INTPV"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PaymentMode")
@XmlEnum
public enum PaymentMode {

    CONTACTLESS,
    MOBILE,
    INTPV;

    public String value() {
        return name();
    }

    public static PaymentMode fromValue(String v) {
        return valueOf(v);
    }

}
