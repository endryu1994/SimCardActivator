package com.akybenko.activation.task;

import static com.akybenko.activation.Constants.*;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

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
public class SimPreActivateTask implements JavaDelegate {

    private final WebService webService;
    private final RabbitMqSenderService rabbitMqSenderService;
    private final WebServiceResponseStatusAnalyzer analyzer;

    @Override
    public void execute(DelegateExecution execution) {
        SimActivateRequest request = (SimActivateRequest) execution.getVariable(REQUEST);
        Response response = webService.getSimPreActivateResponse(request);
        rabbitMqSenderService.convertAndSend(SIM_PRE_ACTIVATE, response);
        boolean isError = analyzer.isErrorWebServiceStatus(response.getResponseHeader().getStatus());
        execution.setVariable(STEP, SPS_CREATE_SIM);
        execution.setVariable(ERROR, isError);
    }
}
