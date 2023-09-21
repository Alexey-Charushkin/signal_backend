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
      // @Mapping(target = "status", expression = "java(shortResponseDeliveryOrderDto.getDelivery_order_status.name().toUppercase())")
    DeliveryOrder toDeliveryOrder(ShortResponseDeliveryOrderDto shortResponseDeliveryOrderDto);

    ShortRequestDeliveryOrderDto toShortRequestDeliveryOrderDto(DeliveryOrder deliveryOrder);

    CancelDto toCancelDto(DeliveryOrder deliveryOrder);

    AcceptDto toAcceptDto(DeliveryOrder deliveryOrder);

    RoutePoint toRoutePoint(ShortResponseRoutePointDto shortResponseRoutePointDto);

    @Mapping(target = "type", expression = "java(routePoint.getType().name().toLowerCase())")
    ShortRequestRoutePointDto toShortRoutePointDto(RoutePoint routePoint);


}
