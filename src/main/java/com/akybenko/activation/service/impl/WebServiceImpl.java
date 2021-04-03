package com.akybenko.activation.service.impl;

import static com.akybenko.activation.Constants.*;
import static com.akybenko.activation.mapstruct.SimActivateRequestToWebServiceRequest.INSTANCE;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.akybenko.activation.ApplicationProperties;
import com.akybenko.activation.model.SimActivateRequest;
import com.akybenko.activation.model.ws.*;
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
    public Response getSimPreActivateResponse(SimActivateRequest request) {
        return getResponse(
                request,
                INSTANCE.getParameter(IMSI, String.valueOf(request.getSimPreActivate().getImsi())),
                INSTANCE.getParameter(ALGORITHM_ID, String.valueOf(request.getSimPreActivate().getAlgorithmId())),
                INSTANCE.getParameter(MSISDN, String.valueOf(request.getSimPreActivate().getMsisdn())),
                INSTANCE.getParameter(TRANSACTION_TYPE, request.getSimPreActivate().getTransactionType()),
                INSTANCE.getParameter(RFS, request.getSimPreActivate().getRfs()),
                INSTANCE.getParameter(ENCRYPTION_KEY, request.getSimPreActivate().getEncryptionKey()),
                INSTANCE.getParameter(KDBID, String.valueOf(request.getSimPreActivate().getKdbid())));
    }

    @Override
    public Response getSpsCreateSimResponse(SimActivateRequest request) {
        return getResponse(
                request,
                INSTANCE.getParameter(IMSI, String.valueOf(request.getSpsCreateSim().getImsi())),
                INSTANCE.getParameter(ACCOUNT_ID, String.valueOf(request.getSpsCreateSim().getAccountId())),
                INSTANCE.getParameter(GROUP, request.getSpsCreateSim().getGroup()),
                INSTANCE.getParameter(RFS, request.getSpsCreateSim().getRfs()),
                INSTANCE.getParameter(MSISDN, String.valueOf(request.getSpsCreateSim().getMsisdn())),
                INSTANCE.getParameter(PHONE_NUMBER, String.valueOf(request.getSpsCreateSim().getPhoneNumber())),
                INSTANCE.getParameter(TRANSACTION_TYPE, request.getSpsCreateSim().getTransactionType()));
    }

    private Response getResponse(SimActivateRequest request, Parameter... parameters) {
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
