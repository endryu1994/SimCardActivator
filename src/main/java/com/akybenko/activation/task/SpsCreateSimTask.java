package com.akybenko.activation.task;

import static com.akybenko.activation.Constants.*;
import static com.akybenko.activation.mapstruct.WebServiceResponseToOutgoingMessage.INSTANCE;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.akybenko.activation.model.OutgoingMessage;
import com.akybenko.activation.model.SimActivateRequest;
import com.akybenko.activation.model.ws.server.Response;
import com.akybenko.activation.service.RabbitMqSenderService;
import com.akybenko.activation.service.WebService;
import com.akybenko.activation.service.WebServiceResponseStatusAnalyzer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class SpsCreateSimTask implements JavaDelegate {

    private final WebService webService;
    private final RabbitMqSenderService rabbitMqSenderService;
    private final WebServiceResponseStatusAnalyzer analyzer;

    @Override
    public void execute(DelegateExecution execution) {
        SimActivateRequest request = (SimActivateRequest) execution.getVariable(REQUEST);
        Response response = webService.getSpsCreateSimResponse(request);
        log.debug("[{}] Response: {}", execution.getProcessInstanceId(), response);
        convertAndSend(response);
        execution.setVariable(STEP, NOTIFICATION);
        execution.setVariable(ERROR, isError(response));
    }

    private void convertAndSend(Response response) {
        OutgoingMessage outgoingMessage = INSTANCE.getOutgoingMessage(response, SPS_CREATE_SIM);
        rabbitMqSenderService.convertAndSend(outgoingMessage);
    }

    private boolean isError(Response response) {
        return analyzer.analyze(response.getResponseHeader().getStatus());
    }
}
