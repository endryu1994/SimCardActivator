package com.akybenko.activation.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.akybenko.activation.model.Header;
import com.akybenko.activation.model.ws.Parameter;
import com.akybenko.activation.model.ws.Request;
import com.akybenko.activation.model.ws.RequestHeader;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SimActivateRequestToWebServiceRequest {

    SimActivateRequestToWebServiceRequest INSTANCE = Mappers.getMapper(SimActivateRequestToWebServiceRequest.class);

    RequestHeader getRequestHeader(Header header);

    Parameter getParameter(String name, String value);

    Request getRequest(RequestHeader requestHeader, Request.RequestParameters requestParameters);
}
