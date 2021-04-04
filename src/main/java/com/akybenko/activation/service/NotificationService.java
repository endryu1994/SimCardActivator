package com.akybenko.activation.service;

import org.springframework.scheduling.annotation.Async;

import com.akybenko.activation.model.ws.client.Notification;

public interface NotificationService {

    @Async("threadPoolTaskExecutor")
    void execute(Notification request);
}
