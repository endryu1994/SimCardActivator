package com.akybenko.activation.model;

import static com.akybenko.activation.Constants.*;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;

import lombok.Data;

@Data
public class SpsCreateSim implements Serializable {

    private Long imsi;
    private BigInteger accountId;
    private String group;
    private String rfs;
    private Long msisdn;
    private Long phoneNumber;
    private String transactionType;

    public SpsCreateSim(Map<String, String> map) {
        if (nonNull(map)) {
            imsi = Long.valueOf(map.get(IMSI));
            accountId = new BigInteger(map.get(ACCOUNT_ID));
            group = map.get(GROUP);
            rfs = map.get(RFS);
            msisdn = Long.valueOf(map.get(MSISDN));
            phoneNumber = Long.valueOf(map.get(PHONE_NUMBER));
            transactionType = map.get(TRANSACTION_TYPE);
        }
    }
}
