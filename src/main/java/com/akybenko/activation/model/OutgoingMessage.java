package com.akybenko.activation.model;

import lombok.Data;

@Data
public class OutgoingMessage {

    private String step;
    private String order;
    private Integer status;
}
