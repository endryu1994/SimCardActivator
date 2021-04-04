package com.akybenko.activation.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.akybenko.activation.model.ws.client.NotificationResponse;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface NotificationResponseMapper {

    NotificationResponseMapper INSTANCE = Mappers.getMapper(NotificationResponseMapper.class);

    NotificationResponse getNotificationResponse(String value);
}
