package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRoutePointDtoToRequest;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRoutePointDtoToResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoutePointMapper {
    RoutePoint toRoutePoint(ShortRoutePointDtoToResponse shortRoutePointDtoToResponse);

    @Mapping(target = "type", expression = "java(routePoint.getType().name().toLowerCase())")
    @Mapping(target = "visit_status", expression = "java(routePoint.getVisit_status().name().toLowerCase())")
    ShortRoutePointDtoToRequest toShortRoutePointDto(RoutePoint routePoint);

}
