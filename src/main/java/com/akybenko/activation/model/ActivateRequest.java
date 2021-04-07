package com.akybenko.activation.model;

import static com.akybenko.activation.Constants.*;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class ActivateRequest implements Serializable {

    private Header header;
    private Activate activate;
    private Create create;

    public ActivateRequest(Map<String, Map<String, String>> map) {
        if (nonNull(map)) {
            header = new Header(map.get(HEADER));
            activate = new Activate(map.get(ACTIVATE));
            create = new Create(map.get(CREATE));
        }
    }
}
