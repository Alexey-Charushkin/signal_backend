package com.example.backend.yandex_delivery.model.express_delivery_interval.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestRoutePointDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseRoutePointDto;
import com.example.backend.yandex_delivery.model.express_delivery_interval.SupportedRequirement;
import com.example.backend.yandex_delivery.model.express_delivery_interval.dto.SupportedRequirementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupportedRequirementMapper {

    SupportedRequirement toSupportedRequirement(SupportedRequirementDto supportedRequirementDto);

    @Mapping(target = "type", expression = "java(supportedRequirement.getType().name().toLowerCase())")
    SupportedRequirementDto toSupportedRequirementDto(SupportedRequirement supportedRequirement);

}
