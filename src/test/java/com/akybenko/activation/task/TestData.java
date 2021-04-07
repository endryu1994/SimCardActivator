package com.akybenko.activation.task;

import static com.akybenko.activation.Constants.*;

import java.util.HashMap;
import java.util.Map;

import com.akybenko.activation.model.SimActivateRequest;
import com.akybenko.activation.model.ws.server.Response;
import com.akybenko.activation.model.ws.server.ResponseHeader;

class TestData {

    private static final String ORDER_VALUE = "9155901180513467490";
    private static final String TYPE_VALUE = "MOBILE";
    private static final String USER_VALUE = "BSS";
    private static final Integer PRIORITY_VALUE = 5;
    private static final String IMSI_VALUE = "440110010000413";
    private static final String MSISDN_VALUE = "817010020885";
    private static final String ACCOUNT_ID_VALUE = "9155901184313467490";
    private static final String ALGORITHM_ID_VALUE = "1";
    private static final String GROUP_VALUE = String.format("%s%s", "group_", ACCOUNT_ID_VALUE);
    private static final String ENCRYPTION_KEY_VALUE = "B3EC1872947572E18A9054B78EF908C0";
    private static final String KDBID_VALUE = "10";
    private static final String STEP_VALUE = "simPreActivate";
    private static final String RFS_SIM_VALUE = "SIM";
    private static final String RFS_SPS_VALUE = "SPS";
    private static final String TRANSACTION_TYPE_PRE_ACTIVATE_VALUE = "PREACTIVATE";
    private static final String TRANSACTION_TYPE_CREATE_SIM_VALUE = "CREATESIM";

    protected static Response getResponse(Integer status) {
        Response response = new Response();
        response.setResponseHeader(getResponseHeader(status));
        return response;
    }

    protected static SimActivateRequest getSimActivateRequest() {
        return new SimActivateRequest(getData());
    }

    protected static SimActivateRequest getSimActivateRequestWithEmptyData() {
        return new SimActivateRequest(getEmptyData());
    }

    protected static SimActivateRequest getSimActivateRequestWithNullData() {
        return new SimActivateRequest(null);
    }

    private static ResponseHeader getResponseHeader(Integer status) {
        ResponseHeader header = new ResponseHeader();
        header.setStatus(status);
        header.setOrder(ORDER_VALUE);
        header.setPriority(PRIORITY_VALUE);
        header.setType(TYPE_VALUE);
        header.setUser(USER_VALUE);
        return header;
    }

    private static Map<String, Map<String, String>> getEmptyData() {
        return new HashMap<>();
    }

    private static Map<String, Map<String, String>> getData() {
        Map<String, Map<String, String>> data = new HashMap<>();
        data.put(HEADER, getHeaderData());
        data.put(SIM_PRE_ACTIVATE, getSimPreActivateData());
        data.put(SPS_CREATE_SIM, getSpsCreateSimData());
        return data;
    }

    private static Map<String, String> getHeaderData() {
        Map<String, String> map = new HashMap<>();
        map.put(TYPE, TYPE_VALUE);
        map.put(USER, USER_VALUE);
        map.put(STEP, STEP_VALUE);
        map.put(PRIORITY, PRIORITY_VALUE.toString());
        map.put(ORDER, ORDER_VALUE);
        map.put(IMSI, IMSI_VALUE);
        return map;
    }

    private static Map<String, String> getSimPreActivateData() {
        Map<String, String> map = new HashMap<>();
        map.put(IMSI, IMSI_VALUE);
        map.put(ALGORITHM_ID, ALGORITHM_ID_VALUE);
        map.put(MSISDN, MSISDN_VALUE);
        map.put(TRANSACTION_TYPE, TRANSACTION_TYPE_PRE_ACTIVATE_VALUE);
        map.put(RFS, RFS_SIM_VALUE);
        map.put(ENCRYPTION_KEY, ENCRYPTION_KEY_VALUE);
        map.put(KDBID, KDBID_VALUE);
        return map;
    }

    private static Map<String, String> getSpsCreateSimData() {
        Map<String, String> map = new HashMap<>();
        map.put(IMSI, IMSI_VALUE);
        map.put(ACCOUNT_ID, ACCOUNT_ID_VALUE);
        map.put(GROUP, GROUP_VALUE);
        map.put(TRANSACTION_TYPE, TRANSACTION_TYPE_CREATE_SIM_VALUE);
        map.put(RFS, RFS_SPS_VALUE);
        map.put(MSISDN, MSISDN_VALUE);
        map.put(PHONE_NUMBER, MSISDN_VALUE);
        return map;
    }
}
