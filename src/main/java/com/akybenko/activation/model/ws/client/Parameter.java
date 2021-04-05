package com.akybenko.activation.model.ws.client;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

import lombok.Data;

/**
 * <p>Java class for Parameter complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Parameter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Attribute" type="{http://ws.notification.example.com/}Attribute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="data" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="operation" use="required" type="{http://ws.notification.example.com/}Type" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parameter", propOrder = {
        "attribute"
})
@Data
public class Parameter {

    @XmlElement(name = "Attribute", namespace = "http://ws.notification.example.com/")
    private List<Attribute> attribute;
    @XmlAttribute(name = "order", required = true)
    private String order;
    @XmlAttribute(name = "operation", required = true)
    private Type operation;

    public List<Attribute> getAttribute() {
        if (isNull(attribute)) {
            attribute = new ArrayList<>();
        }
        return attribute;
    }
}
