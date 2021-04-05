package com.akybenko.activation.service.impl;

import static com.akybenko.activation.Constants.NOTIFICATION;
import static com.akybenko.activation.Constants.STATUS_CODE_WS_OK;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;

import com.akybenko.activation.model.ws.client.Notification;
import com.akybenko.activation.service.NotificationService;
import com.akybenko.activation.service.RabbitMqSenderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final RuntimeService runtimeService;
    private final RabbitMqSenderService rabbitMqSenderService;

    @Override
    public void execute(Notification request) {
        String order = request.getParameter().getOrder();
        log.debug("Order: {}", order);
        runtimeService.createMessageCorrelation(NOTIFICATION)
                .processInstanceBusinessKey(order)
                .correlateWithResult();
        rabbitMqSenderService.convertAndSend(NOTIFICATION, order, STATUS_CODE_WS_OK);
    }
}
