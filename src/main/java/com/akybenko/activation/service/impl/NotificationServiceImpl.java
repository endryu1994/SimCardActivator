package com.akybenko.activation.service.impl;

import static com.akybenko.activation.Constants.NOTIFICATION;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;

import com.akybenko.activation.model.ws.client.Notification;
import com.akybenko.activation.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final RuntimeService runtimeService;

    @Override
    public void execute(Notification request) {
        String imsi = request.getParameter().getImsi();
        log.debug("imsi: {}", imsi);
        runtimeService.createMessageCorrelation(NOTIFICATION)
                .processInstanceBusinessKey(imsi)
                .correlateWithResult();
    }
}
