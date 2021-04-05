package com.akybenko.activation.service;

import com.akybenko.activation.model.ws.server.Response;

public interface RabbitMqSenderService {

    void convertAndSend(String step, Response response);

    void convertAndSend(String step, String order, Integer status);
}
