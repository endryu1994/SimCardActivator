package com.akybenko.activation.model;

import static com.akybenko.activation.Constants.*;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class Activate implements Serializable {

    private Long imsi;
    private Integer algorithmId;
    private Long msisdn;
    private String transactionType;
    private String rfs;
    private String encryptionKey;
    private Integer kdbid;

    public Activate(Map<String, String> map) {
        if (nonNull(map)) {
            imsi = Long.valueOf(map.get(IMSI));
            algorithmId = Integer.valueOf(map.get(ALGORITHM_ID));
            msisdn = Long.valueOf(map.get(MSISDN));
            transactionType = map.get(TRANSACTION_TYPE);
            rfs = map.get(RFS);
            encryptionKey = map.get(ENCRYPTION_KEY);
            kdbid = Integer.valueOf(map.get(KDBID));
        }
    }
}
