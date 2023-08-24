package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestRoutePointDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseRoutePointDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoutePointMapper {
    RoutePoint toRoutePoint(ShortResponseRoutePointDto shortResponseRoutePointDto);

    @Mapping(target = "type", expression = "java(routePoint.getType().name().toLowerCase())")
    @Mapping(target = "visit_status", expression = "java(routePoint.getVisit_status().name().toLowerCase())")
    ShortRequestRoutePointDto toShortRoutePointDto(RoutePoint routePoint);

}
