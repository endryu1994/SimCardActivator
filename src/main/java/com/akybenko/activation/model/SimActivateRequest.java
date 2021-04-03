package com.akybenko.activation.model;

import static com.akybenko.activation.Constants.*;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class SimActivateRequest implements Serializable {

    private Header header;
    private SimPreActivate simPreActivate;
    private SpsCreateSim spsCreateSim;

    public SimActivateRequest(Map<String, Map<String, String>> map) {
        if (nonNull(map)) {
            header = new Header(map.get(HEADER));
            simPreActivate = new SimPreActivate(map.get(SIM_PRE_ACTIVATE));
            spsCreateSim = new SpsCreateSim(map.get(SPS_CREATE_SIM));
        }
    }
}
