package com.akybenko.activation.listener;

import static com.akybenko.activation.Constants.*;
import static org.springframework.amqp.support.AmqpHeaders.CHANNEL;
import static org.springframework.amqp.support.AmqpHeaders.DELIVERY_TAG;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.akybenko.activation.model.SimActivateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMqListener {

    private final RuntimeService runtimeService;

    @RabbitListener(queues = "#{applicationProperties.getIncomingQueueName()}")
    public void processIncomingQueue(Message message,
                                     @Header(CHANNEL) Channel channel,
                                     @Header(DELIVERY_TAG) Long tag) throws IOException {
        try {
            String data = new String(message.getBody(), Charset.defaultCharset());
            log.debug("Received message: {}", data);
            Map<String, Map<String, String>> map = getData(data);
            SimActivateRequest request = new SimActivateRequest(map);
            log.debug("Request: {}", request);
            runtimeService.startProcessInstanceByKey(
                    CAMUNDA_PROCESS_NAME, request.getHeader().getImsi(), getVariables(request));
            channel.basicAck(tag, false);
        } catch (Exception e) {
            log.error("Unexpected exception occurred: {}", e.getMessage());
            channel.basicReject(tag, false);
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Map<String, String>> getData(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(data, Map.class);
    }

    private Map<String, Object> getVariables(SimActivateRequest request) {
        ObjectValue requestValue = Variables.objectValue(request)
                .serializationDataFormat(Variables.SerializationDataFormats.JAVA)
                .create();
        return Variables
                .putValue(STEP, request.getHeader().getStep())
                .putValue(IMSI, request.getHeader().getImsi())
                .putValueTyped(REQUEST, requestValue);
    }
}
