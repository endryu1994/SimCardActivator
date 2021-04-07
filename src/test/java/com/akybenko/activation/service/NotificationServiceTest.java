package com.akybenko.activation.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.akybenko.activation.service.impl.NotificationServiceImpl;

@RunWith(SpringRunner.class)
public class NotificationServiceTest {

    private static final String ORDER_VALUE = "9155901180513467490";

    @Mock
    private MessageCorrelationBuilder messageCorrelationBuilder;

    @Mock
    private RuntimeService runtimeService;

    @Mock
    private RabbitMqSenderService rabbitMqSenderService;

    @InjectMocks
    private NotificationServiceImpl service;

    @Before
    public void setUp() {
        when(runtimeService.createMessageCorrelation(any())).thenReturn(messageCorrelationBuilder);
        when(runtimeService.createMessageCorrelation(any()).processInstanceBusinessKey(any()))
                .thenReturn(messageCorrelationBuilder);
    }

    @Test
    public void testExecute_whenResponseIsNotNullAndRequestHasNullData() {
        service.execute(ORDER_VALUE);
    }
}
