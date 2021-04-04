package com.akybenko.activation.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.akybenko.activation.model.Header;
import com.akybenko.activation.model.ws.server.Parameter;
import com.akybenko.activation.model.ws.server.Request;
import com.akybenko.activation.model.ws.server.RequestHeader;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SimActivateRequestToWebServiceRequest {

    SimActivateRequestToWebServiceRequest INSTANCE = Mappers.getMapper(SimActivateRequestToWebServiceRequest.class);

    RequestHeader getRequestHeader(Header header);

    Parameter getParameter(String name, String value);

    Request getRequest(RequestHeader requestHeader, Request.RequestParameters requestParameters);
}
