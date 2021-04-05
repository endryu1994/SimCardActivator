package com.akybenko.activation.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.akybenko.activation.model.OutgoingMessage;
import com.akybenko.activation.model.ws.server.Response;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface WebServiceResponseToOutgoingMessage {

    WebServiceResponseToOutgoingMessage INSTANCE = Mappers.getMapper(WebServiceResponseToOutgoingMessage.class);

    @Mapping(target = "order", source = "response.responseHeader.order")
    @Mapping(target = "status", source = "response.responseHeader.status")
    OutgoingMessage getOutgoingMessage(String step, Response response);

    OutgoingMessage getOutgoingMessage(String step, String order, Integer status);
}
