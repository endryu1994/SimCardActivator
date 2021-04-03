package com.akybenko.activation.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.WebServiceMessageSender;

import com.akybenko.activation.ApplicationProperties;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SoapConfiguration {

    private static final String MODEL_PACKAGE = "com.akybenko.activation.model.ws";
    private static final String UTF_8_ENCODING = "UTF-8";

    private final ApplicationProperties properties;

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(MODEL_PACKAGE);
        marshaller.setMarshallerProperties(properties());
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller());
        webServiceTemplate.setMessageSenders(new WebServiceMessageSender[]{basicAuthConnectionMessageSender()});
        return webServiceTemplate;
    }

    private Map<String, Object> properties() {
        Map<String, Object> map = new HashMap<>();
        map.put(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        map.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        map.put(Marshaller.JAXB_ENCODING, UTF_8_ENCODING);
        return map;
    }

    private WebServiceMessageSender basicAuthConnectionMessageSender() {
        return new BasicAuthConnectionMessageSender(properties.getWsUsername(), properties.getWsPassword());
    }
}
