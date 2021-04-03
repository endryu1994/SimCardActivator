package com.akybenko.activation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ApplicationProperties {

    @Value("${activator.rabbitmq.incoming.queue}")
    private String incomingQueueName;

    @Value("${activator.rabbitmq.incoming.dead.queue}")
    private String incomingDeadQueueName;

    @Value("${activator.rabbitmq.outgoing.queue}")
    private String outgoingQueueName;

    @Value("${activator.rabbitmq.outgoing.dead.queue}")
    private String outgoingDeadQueueName;

    @Value("${activator.rabbitmq.incoming.exchange}")
    private String incomingExchangeName;

    @Value("${activator.rabbitmq.incoming.dead.exchange}")
    private String incomingDeadExchangeName;

    @Value("${activator.rabbitmq.outgoing.exchange}")
    private String outgoingExchangeName;

    @Value("${activator.rabbitmq.outgoing.dead.exchange}")
    private String outgoingDeadExchangeName;

    @Value("${activator.rabbitmq.incoming.routing.key}")
    private String incomingRoutingKey;

    @Value("${activator.rabbitmq.outgoing.routing.key}")
    private String outgoingRoutingKey;

    @Value("${activator.ws.url}")
    private String wsUrl;

    @Value("${activator.ws.username}")
    private String wsUsername;

    @Value("${activator.ws.password}")
    private String wsPassword;
}
