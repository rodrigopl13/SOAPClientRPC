
package com.ws.rpc;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for movieCategories.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="movieCategories">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HORROR"/>
 *     &lt;enumeration value="DRAMA"/>
 *     &lt;enumeration value="THRILLER"/>
 *     &lt;enumeration value="SCIFI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "movieCategories")
@XmlEnum
public enum MovieCategories {

    HORROR,
    DRAMA,
    THRILLER,
    SCIFI;

    public String value() {
        return name();
    }

    public static MovieCategories fromValue(String v) {
        return valueOf(v);
    }

}
