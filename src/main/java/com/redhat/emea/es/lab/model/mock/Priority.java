
package com.redhat.emea.es.lab.model.mock;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Priority.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Priority"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CRITICAL"/&gt;
 *     &lt;enumeration value="HIGH"/&gt;
 *     &lt;enumeration value="NORMAL"/&gt;
 *     &lt;enumeration value="LOW"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Priority")
@XmlEnum
public enum Priority {

    CRITICAL,
    HIGH,
    NORMAL,
    LOW;

    public String value() {
        return name();
    }

    public static Priority fromValue(String v) {
        return valueOf(v);
    }

}
