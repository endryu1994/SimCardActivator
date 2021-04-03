package com.akybenko.activation.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akybenko.activation.ApplicationProperties;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class RabbitMqConfiguration {

    private static final String DEAD_LETTER_EXCHANGE_ARGUMENT_NAME = "x-dead-letter-exchange";

    private final ApplicationProperties properties;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue incomingQueue() {
        return QueueBuilder.durable(properties.getIncomingQueueName())
                .withArgument(DEAD_LETTER_EXCHANGE_ARGUMENT_NAME, properties.getIncomingDeadExchangeName())
                .build();
    }

    @Bean
    public Queue incomingDeadQueue() {
        return QueueBuilder.durable(properties.getIncomingDeadQueueName()).build();
    }

    @Bean
    public Queue outgoingQueue() {
        return QueueBuilder.durable(properties.getOutgoingQueueName())
                .withArgument(DEAD_LETTER_EXCHANGE_ARGUMENT_NAME, properties.getOutgoingDeadExchangeName())
                .build();
    }

    @Bean
    public Queue outgoingDeadQueue() {
        return QueueBuilder.durable(properties.getOutgoingDeadQueueName()).build();
    }

    @Bean
    public DirectExchange incomingExchange() {
        return ExchangeBuilder.directExchange(properties.getIncomingExchangeName()).build();
    }

    @Bean
    public FanoutExchange incomingDeadExchange() {
        return ExchangeBuilder.fanoutExchange(properties.getIncomingDeadExchangeName()).build();
    }

    @Bean
    public DirectExchange outgoingExchange() {
        return ExchangeBuilder.directExchange(properties.getOutgoingExchangeName()).build();
    }

    @Bean
    public FanoutExchange outgoingDeadExchange() {
        return ExchangeBuilder.fanoutExchange(properties.getOutgoingDeadExchangeName()).build();
    }

    @Bean
    public Binding bindingIncomingMessages() {
        return BindingBuilder.bind(incomingQueue()).to(incomingExchange()).with(properties.getIncomingRoutingKey());
    }

    @Bean
    public Binding bindingIncomingDeadMessages() {
        return BindingBuilder.bind(incomingDeadQueue()).to(incomingDeadExchange());
    }

    @Bean
    public Binding bindingOutgoingMessages() {
        return BindingBuilder.bind(outgoingQueue()).to(outgoingExchange()).with(properties.getOutgoingRoutingKey());
    }

    @Bean
    public Binding bindingOutgoingDeadMessages() {
        return BindingBuilder.bind(outgoingDeadQueue()).to(outgoingDeadExchange());
    }
}
