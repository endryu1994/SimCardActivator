package com.akybenko.activation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {

    // Request parameters
    public static final String IMSI = "imsi";
    public static final String ALGORITHM_ID = "algorithmId";
    public static final String MSISDN = "msisdn";
    public static final String TRANSACTION_TYPE = "transactionType";
    public static final String RFS = "rfs";
    public static final String ENCRYPTION_KEY = "encryptionKey";
    public static final String KDBID = "kdbid";
    public static final String ACCOUNT_ID = "accountId";
    public static final String GROUP = "group";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String TYPE = "type";
    public static final String USER = "user";
    public static final String STEP = "step";
    public static final String PRIORITY = "priority";
    public static final String ORDER = "order";
    public static final String HEADER = "header";

    // Step
    public static final String ACTIVATE = "activate";
    public static final String CREATE = "create";
    public static final String NOTIFICATION = "notification";

    // Camunda
    public static final String CAMUNDA_PROCESS_NAME = "SimCardActivator";

    // Variables
    public static final String REQUEST = "request";
    public static final String ERROR = "error";

    public static final Integer STATUS_CODE_WS_OK = 9;
}
