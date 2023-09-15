package com.example.backend.yandex_delivery.model.delivery_order.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrder;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import com.example.backend.yandex_delivery.model.delivery_order.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryOrderMapper {
    @Mapping(target = "created_ts", source = "shortResponseDeliveryOrderDto.created_ts", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "updated_ts", source = "shortResponseDeliveryOrderDto.updated_ts", dateFormat = "dd-MM-yyyy HH:mm:ss")
    DeliveryOrder toDeliveryOrder(ShortResponseDeliveryOrderDto shortResponseDeliveryOrderDto);

    ShortRequestDeliveryOrderDto toShortRequestDeliveryOrderDto(DeliveryOrder deliveryOrder);

    CancelDto toCancelDto(DeliveryOrder deliveryOrder);

    AcceptDto toAcceptDto(DeliveryOrder deliveryOrder);

    RoutePoint toRoutePoint(ShortResponseRoutePointDto shortResponseRoutePointDto);

    @Mapping(target = "type", expression = "java(routePoint.getType().name().toLowerCase())")
   // @Mapping(target = "visit_status", expression = "java(routePoint.getVisit_status().name().toLowerCase())")
    ShortRequestRoutePointDto toShortRoutePointDto(RoutePoint routePoint);
}
