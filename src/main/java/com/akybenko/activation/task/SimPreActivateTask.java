package com.akybenko.activation.task;

import static com.akybenko.activation.Constants.*;
import static com.akybenko.activation.mapstruct.WebServiceResponseToOutgoingMessage.INSTANCE;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.akybenko.activation.model.OutgoingMessage;
import com.akybenko.activation.model.SimActivateRequest;
import com.akybenko.activation.model.ws.Response;
import com.akybenko.activation.service.RabbitMqSenderService;
import com.akybenko.activation.service.WebService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class SimPreActivateTask implements JavaDelegate {

    private final WebService webService;
    private final RabbitMqSenderService rabbitMqSenderService;

    @Override
    public void execute(DelegateExecution execution) {
        SimActivateRequest request = (SimActivateRequest) execution.getVariable(REQUEST);
        Response response = webService.getSimPreActivateResponse(request);
        log.debug("[{}] Response: {}", execution.getProcessInstanceId(), response);
        OutgoingMessage outgoingMessage = INSTANCE.getOutgoingMessage(response, SIM_PRE_ACTIVATE);
        rabbitMqSenderService.convertAndSend(outgoingMessage);
        execution.setVariable(STEP, SIM_PRE_ACTIVATE);
        execution.setVariable(STATUS, outgoingMessage.getStatus());
    }
}
