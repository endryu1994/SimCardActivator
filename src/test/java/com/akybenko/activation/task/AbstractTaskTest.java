package com.akybenko.activation.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.mockito.Mock;

import com.akybenko.activation.service.RabbitMqSenderService;
import com.akybenko.activation.service.WebService;
import com.akybenko.activation.service.WebServiceResponseStatusAnalyzer;

abstract class AbstractTaskTest {

    @Mock
    protected DelegateExecution execution;

    @Mock
    protected WebService webService;

    @Mock
    protected RabbitMqSenderService rabbitMqSenderService;

    @Mock
    protected WebServiceResponseStatusAnalyzer analyzer;
}
