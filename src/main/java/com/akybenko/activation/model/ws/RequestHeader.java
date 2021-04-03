
package com.akybenko.activation.model.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

/**
 * <p>Java class for RequestHeader complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RequestHeader"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="Type" type="{http://ws.example.com/}NonEmptyString"/&gt;
 *         &lt;element name="Order" type="{http://ws.example.com/}NonEmptyString"/&gt;
 *         &lt;element name="Priority" type="{http://ws.example.com/}OneToTen"/&gt;
 *         &lt;element name="User" type="{http://ws.example.com/}NonEmptyString"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestHeader", propOrder = {
})
@Data
public class RequestHeader {

    @XmlElement(name = "Type", namespace = "http://ws.example.com/", required = true)
    private String type;
    @XmlElement(name = "Order", namespace = "http://ws.example.com/", required = true)
    private String order;
    @XmlElement(name = "Priority", namespace = "http://ws.example.com/", required = true)
    private Integer priority;
    @XmlElement(name = "User", namespace = "http://ws.example.com/", required = true)
    private String user;
}
