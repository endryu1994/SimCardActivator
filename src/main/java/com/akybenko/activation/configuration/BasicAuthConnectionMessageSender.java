package com.akybenko.activation.configuration;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.DatatypeConverter;

import org.springframework.http.HttpHeaders;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

public class BasicAuthConnectionMessageSender extends HttpUrlConnectionMessageSender {

    private final String credentials;

    public BasicAuthConnectionMessageSender(String username, String password) {
        byte[] bytes = String.format("%s:%s", username, password).getBytes(StandardCharsets.UTF_8);
        credentials = DatatypeConverter.printBase64Binary(bytes);
    }

    @Override
    protected void prepareConnection(HttpURLConnection connection) throws IOException {
        connection.setRequestProperty(HttpHeaders.AUTHORIZATION, String.format("Basic %s", credentials));
        super.prepareConnection(connection);
    }
}
