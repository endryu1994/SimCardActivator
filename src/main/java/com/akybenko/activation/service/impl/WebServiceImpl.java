package com.akybenko.activation.service.impl;

import static com.akybenko.activation.Constants.*;
import static com.akybenko.activation.mapstruct.ActivateRequestToWebServiceRequest.INSTANCE;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.akybenko.activation.ApplicationProperties;
import com.akybenko.activation.model.ActivateRequest;
import com.akybenko.activation.model.ws.server.Parameter;
import com.akybenko.activation.model.ws.server.Request;
import com.akybenko.activation.model.ws.server.RequestHeader;
import com.akybenko.activation.model.ws.server.Response;
import com.akybenko.activation.service.WebService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class WebServiceImpl implements WebService {

    private static final String SOAP_ACTION = "urn:request";

    private final WebServiceTemplate webServiceTemplate;
    private final ApplicationProperties properties;

    @Override
    public Response getActivateResponse(ActivateRequest request) {
        return getResponse(
                request,
                INSTANCE.getParameter(IMSI, String.valueOf(request.getActivate().getImsi())),
                INSTANCE.getParameter(ALGORITHM_ID, String.valueOf(request.getActivate().getAlgorithmId())),
                INSTANCE.getParameter(MSISDN, String.valueOf(request.getActivate().getMsisdn())),
                INSTANCE.getParameter(TRANSACTION_TYPE, request.getActivate().getTransactionType()),
                INSTANCE.getParameter(RFS, request.getActivate().getRfs()),
                INSTANCE.getParameter(ENCRYPTION_KEY, request.getActivate().getEncryptionKey()),
                INSTANCE.getParameter(KDBID, String.valueOf(request.getActivate().getKdbid())));
    }

    @Override
    public Response getCreateResponse(ActivateRequest request) {
        return getResponse(
                request,
                INSTANCE.getParameter(IMSI, String.valueOf(request.getCreate().getImsi())),
                INSTANCE.getParameter(ACCOUNT_ID, String.valueOf(request.getCreate().getAccountId())),
                INSTANCE.getParameter(GROUP, request.getCreate().getGroup()),
                INSTANCE.getParameter(RFS, request.getCreate().getRfs()),
                INSTANCE.getParameter(MSISDN, String.valueOf(request.getCreate().getMsisdn())),
                INSTANCE.getParameter(PHONE_NUMBER, String.valueOf(request.getCreate().getPhoneNumber())),
                INSTANCE.getParameter(TRANSACTION_TYPE, request.getCreate().getTransactionType()));
    }

    private Response getResponse(ActivateRequest request, Parameter... parameters) {
        log.debug("Incoming request: {}", request);
        RequestHeader requestHeader = INSTANCE.getRequestHeader(request.getHeader());
        Request.RequestParameters requestParameters = new Request.RequestParameters();
        requestParameters.setParameters(parameters);
        Request body = INSTANCE.getRequest(requestHeader, requestParameters);
        log.debug("Body: {}", body);
        Response response = (Response) webServiceTemplate.marshalSendAndReceive(
                properties.getWsUrl(), body, new SoapActionCallback(SOAP_ACTION));
        log.debug("Response: {}", response);
        return response;
    }
}
