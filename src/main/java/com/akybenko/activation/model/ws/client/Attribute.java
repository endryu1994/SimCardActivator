
package com.akybenko.activation.model.ws.client;

import javax.xml.bind.annotation.*;

import lombok.Data;

/**
 * <p>Java class for Attribute complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Attribute"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attribute", propOrder = {
        "value"
})
@Data
public class Attribute {

    @XmlElement(name = "Value", namespace = "http://ws.notification.example.com/", required = true)
    private String value;
    @XmlAttribute(name = "name", required = true)
    private String name;
}
