package com.akybenko.activation.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.akybenko.activation.ApplicationProperties;
import com.akybenko.activation.service.impl.RabbitMqSenderServiceImpl;

@RunWith(SpringRunner.class)
public class RabbitMqSenderServiceTest {

    @Mock
    private AmqpTemplate rabbitTemplate;

    @Mock
    private ApplicationProperties properties;

    @InjectMocks
    private RabbitMqSenderServiceImpl service;

    @Test
    public void testConvertAndSend_whenStepIsNullAndResponseIsNull() {
        service.convertAndSend(null, null);
    }

    @Test
    public void testConvertAndSend_whenStepIsNullAndOrderIsNullAndStatusIsNull() {
        service.convertAndSend(null, null, null);
    }
}
