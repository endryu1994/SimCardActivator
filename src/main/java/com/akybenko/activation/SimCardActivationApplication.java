package com.akybenko.activation;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.ws.config.annotation.EnableWs;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
@EnableProcessApplication
@EnableWs
@EnableAsync
public class SimCardActivationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimCardActivationApplication.class, args);
    }
}
