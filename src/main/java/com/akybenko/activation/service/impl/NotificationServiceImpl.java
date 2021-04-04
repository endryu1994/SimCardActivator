package com.akybenko.activation.service.impl;

import static com.akybenko.activation.Constants.IMSI;

import org.springframework.stereotype.Service;

import com.akybenko.activation.exception.SimCardActivatorException;
import com.akybenko.activation.model.ws.client.Notification;
import com.akybenko.activation.service.NotificationService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private static final String COMMA = ",";
    private static final String EQUAL = "=";

    @Override
    public void execute(Notification request) {
        String imsi = getImsi(request.getParameter().getData());
        log.debug("IMSI: {}", imsi);
    }

    private String getImsi(String data) {
        String[] params = data.split(COMMA);
        for (String param : params) {
            String[] keyValue = param.split(EQUAL);
            if (IMSI.equals(keyValue[0])) {
                return keyValue[1];
            }
        }
        throw new SimCardActivatorException("IMSI is not found");
    }
}
