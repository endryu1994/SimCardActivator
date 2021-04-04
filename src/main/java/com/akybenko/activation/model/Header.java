package com.akybenko.activation.model;

import static com.akybenko.activation.Constants.*;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class Header implements Serializable {

    private String type;
    private String user;
    private String step;
    private Integer priority;
    private String order;
    private String imsi;

    public Header(Map<String, String> map) {
        if (nonNull(map)) {
            type = map.get(TYPE);
            user = map.get(USER);
            step = map.get(STEP);
            priority = Integer.valueOf(map.get(PRIORITY));
            order = map.get(ORDER);
            imsi = map.get(IMSI);
        }
    }
}
