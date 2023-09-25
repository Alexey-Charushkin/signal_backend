package com.example.backend.yandex_delivery.model.delivery_order.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrder;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import com.example.backend.yandex_delivery.model.delivery_order.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryOrderMapper {

    @Mapping(target = "created_ts", source = "shortResponseDeliveryOrderDto.created_ts", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    @Mapping(target = "updated_ts", source = "shortResponseDeliveryOrderDto.updated_ts", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    @Mapping(target = "status", expression = "java(com.example.backend.yandex_delivery.enums.DeliveryOrderStatus." +
            "valueOf(shortResponseDeliveryOrderDto.getStatus().toUpperCase()))")
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "available_cancel_state", expression = "java(com.example.backend.yandex_delivery.enums.CancelState." +
            "valueOf(shortResponseDeliveryOrderDto.getAvailable_cancel_state().toUpperCase()))")
    DeliveryOrder toDeliveryOrder(ShortResponseDeliveryOrderDto shortResponseDeliveryOrderDto);

    ShortRequestDeliveryOrderDto toShortRequestDeliveryOrderDto(DeliveryOrder deliveryOrder);

    CancelDto toCancelDto(DeliveryOrder deliveryOrder);

    AcceptDto toAcceptDto(DeliveryOrder deliveryOrder);

    @Mapping(target = "type", expression = "java(com.example.backend.yandex_delivery.enums.RoutePointType." +
            "valueOf(shortResponseRoutePointDto.getType().toUpperCase()))")
    @Mapping(target = "visit_status", expression = "java(com.example.backend.yandex_delivery.enums." +
            "VisitStatus.valueOf(shortResponseRoutePointDto.getVisitStatus().toUpperCase()))")
    RoutePoint toRoutePoint(ShortResponseRoutePointDto shortResponseRoutePointDto);

    @Mapping(target = "type", expression = "java(routePoint.getType().name().toLowerCase())")
    ShortRequestRoutePointDto toShortRoutePointDto(RoutePoint routePoint);


}
