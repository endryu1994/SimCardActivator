package com.akybenko.activation.service;

import org.springframework.scheduling.annotation.Async;

public interface NotificationService {

    @Async("threadPoolTaskExecutor")
    void execute(String order);
}
