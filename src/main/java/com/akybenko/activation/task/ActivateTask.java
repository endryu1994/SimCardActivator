package com.akybenko.activation.task;

import static com.akybenko.activation.Constants.*;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.akybenko.activation.model.ActivateRequest;
import com.akybenko.activation.model.ws.server.Response;
import com.akybenko.activation.service.RabbitMqSenderService;
import com.akybenko.activation.service.WebService;
import com.akybenko.activation.service.WebServiceResponseStatusAnalyzer;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ActivateTask implements JavaDelegate {

    private final WebService webService;
    private final RabbitMqSenderService rabbitMqSenderService;
    private final WebServiceResponseStatusAnalyzer analyzer;

    @Override
    public void execute(DelegateExecution execution) {
        ActivateRequest request = (ActivateRequest) execution.getVariable(REQUEST);
        Response response = webService.getActivateResponse(request);
        rabbitMqSenderService.convertAndSend(ACTIVATE, response);
        boolean isError = analyzer.isErrorWebServiceStatus(response.getResponseHeader().getStatus());
        execution.setVariable(STEP, CREATE);
        execution.setVariable(ERROR, isError);
    }
}
