package com.akybenko.activation.listener;

import static com.akybenko.activation.listener.TestData.DATA;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.engine.runtime.ProcessInstanceQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.amqp.core.Message;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitmq.client.Channel;

@RunWith(SpringRunner.class)
public class RabbitMqListenerTest {

    @Mock
    private ProcessInstanceQuery processInstanceQuery;

    @Mock
    private Message message;

    @Mock
    private Channel channel;

    @Mock
    private RuntimeService runtimeService;

    @InjectMocks
    private RabbitMqListener listener;

    @Test
    public void testProcessIncomingQueue_shouldReject_whenMessageIsNull() throws IOException {
        listener.processIncomingQueue(message, channel, 1L);
    }

    @Test
    public void testProcessIncomingQueue_shouldAck_whenActiveProcessExists() throws IOException {
        when(message.getBody()).thenReturn(DATA);
        when(runtimeService.createProcessInstanceQuery()).thenReturn(processInstanceQuery);
        when(runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(any()))
                .thenReturn(processInstanceQuery);
        when(runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(any()).active())
                .thenReturn(processInstanceQuery);
        when(runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(any()).active().singleResult())
                .thenReturn(new ExecutionEntity());
        listener.processIncomingQueue(message, channel, 1L);
    }

    @Test
    public void testProcessIncomingQueue_shouldAck_whenActiveProcessIsNotExists() throws IOException {
        when(message.getBody()).thenReturn(DATA);
        when(runtimeService.createProcessInstanceQuery()).thenReturn(processInstanceQuery);
        when(runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(any()))
                .thenReturn(processInstanceQuery);
        when(runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(any()).active())
                .thenReturn(processInstanceQuery);
        when(runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(any()).active().singleResult())
                .thenReturn(null);
        listener.processIncomingQueue(message, channel, 1L);
    }
}
