package com.akybenko.activation.service;

import com.akybenko.activation.model.OutgoingMessage;

public interface RabbitMqSenderService {

    void convertAndSend(OutgoingMessage message);
}
