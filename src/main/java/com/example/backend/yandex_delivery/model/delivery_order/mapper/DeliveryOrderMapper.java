package com.example.backend.yandex_delivery.model.delivery_order.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrder;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestRoutePointDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseRoutePointDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryOrderMapper {
    @Mapping(target="created_ts", source = "shortResponseDeliveryOrderDto.created_ts", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target="updated_ts", source = "shortResponseDeliveryOrderDto.updated_ts", dateFormat = "dd-MM-yyyy HH:mm:ss")
    DeliveryOrder toDeliveryOrder(ShortResponseDeliveryOrderDto shortResponseDeliveryOrderDto);

    ShortRequestDeliveryOrderDto  toShortRequestDeliveryOrderDto (DeliveryOrder deliveryOrder);

}
