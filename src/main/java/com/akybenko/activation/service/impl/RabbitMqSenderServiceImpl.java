package com.akybenko.activation.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.akybenko.activation.ApplicationProperties;
import com.akybenko.activation.model.OutgoingMessage;
import com.akybenko.activation.service.RabbitMqSenderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class RabbitMqSenderServiceImpl implements RabbitMqSenderService {

    private final AmqpTemplate rabbitTemplate;
    private final ApplicationProperties properties;

    @Override
    public void convertAndSend(OutgoingMessage message) {
        log.debug("Message to RabbitMQ: {}", message);
        rabbitTemplate.convertAndSend(
                properties.getOutgoingExchangeName(), properties.getOutgoingRoutingKey(), message);
    }
}
