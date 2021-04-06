package com.akybenko.activation.mapstruct;

import static com.akybenko.activation.Constants.*;
import static com.akybenko.activation.Constants.USER;

import java.util.HashMap;
import java.util.Map;

import com.akybenko.activation.model.ws.server.Request;
import com.akybenko.activation.model.ws.server.RequestHeader;
import com.akybenko.activation.model.ws.server.Response;
import com.akybenko.activation.model.ws.server.ResponseHeader;

class TestData {

    protected static final String TYPE_VALUE = "MOBILE";
    protected static final String ORDER_VALUE = "9155901180513467490";
    protected static final String PRIORITY_VALUE = "5";
    protected static final String USER_VALUE = "BSS";
    protected static final Integer PRIORITY_INTEGER_VALUE = Integer.valueOf(PRIORITY_VALUE);
    protected static final RequestHeader EMPTY_REQUEST_HEADERS = new RequestHeader();
    protected static final Request.RequestParameters EMPTY_REQUEST_PARAMETERS = new Request.RequestParameters();
    protected static final Response EMPTY_RESPONSE = new Response();

    protected static Map<String, String> getHeaderParameters() {
        Map<String, String> map = new HashMap<>();
        map.put(TYPE, TYPE_VALUE);
        map.put(ORDER, ORDER_VALUE);
        map.put(PRIORITY, PRIORITY_VALUE);
        map.put(USER, USER_VALUE);
        return map;
    }

    protected static Response getResponseWithEmptyResponseHeader() {
        Response response = new Response();
        response.setResponseHeader(new ResponseHeader());
        return response;
    }

    protected static Response getResponseWithNotEmptyResponseHeader() {
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setOrder(ORDER_VALUE);
        responseHeader.setStatus(STATUS_CODE_WS_OK);
        Response response = new Response();
        response.setResponseHeader(responseHeader);
        return response;
    }
}
