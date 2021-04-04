package com.akybenko.activation.model.ws.client;

import javax.xml.bind.annotation.*;

import lombok.Data;

/**
 * <p>Java class for Notification complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Notification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://ws.notification.example.com/}Parameter"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Notification", propOrder = {
        "parameter"
})
@XmlRootElement(name = "Notification", namespace = "http://ws.notification.example.com/")
@Data
public class Notification {

    @XmlElement(name = "Parameter", namespace = "http://ws.notification.example.com/", required = true)
    private Parameter parameter;
}
