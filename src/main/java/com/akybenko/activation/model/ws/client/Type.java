package com.akybenko.activation.model.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>Java class for Type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="add"/&gt;
 *     &lt;enumeration value="update"/&gt;
 *     &lt;enumeration value="delete"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "Type")
@XmlEnum
@AllArgsConstructor
@Getter
public enum Type {

    @XmlEnumValue("add")
    ADD("add"),
    @XmlEnumValue("update")
    UPDATE("update"),
    @XmlEnumValue("delete")
    DELETE("delete");
    private final String value;

    public static Type fromValue(String v) {
        for (Type c : Type.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
