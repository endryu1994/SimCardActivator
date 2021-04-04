package com.akybenko.activation.configuration;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.akybenko.activation.ApplicationProperties;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class ThreadExecutorConfiguration {

    private final ApplicationProperties properties;

    @Bean
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(properties.getCorePoolSize());
        executor.setMaxPoolSize(properties.getMaxPoolSize());
        executor.setQueueCapacity(properties.getQueueCapacity());
        executor.setThreadNamePrefix(properties.getThreadPrefixName());
        executor.initialize();
        return executor;
    }
}
