package com.akybenko.activation.listener;

import static com.akybenko.activation.mapstruct.NotificationResponseMapper.INSTANCE;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.akybenko.activation.model.ws.client.Notification;
import com.akybenko.activation.model.ws.client.NotificationResponse;
import com.akybenko.activation.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Endpoint
@AllArgsConstructor
@Slf4j
public class NotificationListener {

    private static final String NAMESPACE = "http://ws.notification.example.com/";

    private final NotificationService notificationService;

    @PayloadRoot(namespace = NAMESPACE, localPart = "Notification")
    @ResponsePayload
    public NotificationResponse getNotification(@RequestPayload Notification request) {
        log.debug("Input request: {}", request);
        String order = request.getParameter().getOrder();
        notificationService.execute(order);
        NotificationResponse response = INSTANCE.getNotificationResponse(order);
        log.debug("Response: {}", response);
        return response;
    }
}
