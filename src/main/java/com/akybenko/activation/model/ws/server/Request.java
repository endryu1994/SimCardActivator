package com.akybenko.activation.model.ws.server;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.*;

import lombok.Data;

/**
 * <p>Java class for Request complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RequestHeader" type="{http://ws.example.com/}Header"/&gt;
 *         &lt;element name="RequestParameters"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Parameter" type="{http://ws.example.com/}Parameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = {
        "requestHeader",
        "requestParameters"
})
@XmlRootElement(name = "Request", namespace = "http://ws.example.com/")
@Data
public class Request {

    @XmlElement(name = "RequestHeader", namespace = "http://ws.example.com/", required = true)
    private RequestHeader requestHeader;
    @XmlElement(name = "RequestParameters", namespace = "http://ws.example.com/", required = true)
    private RequestParameters requestParameters;

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
     *         &lt;element name="Parameter" type="{http://ws.example.com/}Parameter" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "parameters"
    })
    @Data
    public static class RequestParameters {

        @XmlElement(name = "Parameter", namespace = "http://ws.example.com/")
        private List<Parameter> parameters;

        public List<Parameter> getParameters() {
            if (isNull(parameters)) {
                parameters = new ArrayList<>();
            }
            return this.parameters;
        }

        public void setParameters(Parameter... parameters) {
            this.parameters = Arrays.asList(parameters);
        }
    }
}
