package com.example.backend.yandex_delivery.model.express_delivery_interval.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrder;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.express_delivery_interval.ExpressDelivery;
import com.example.backend.yandex_delivery.model.express_delivery_interval.dto.ResponseExpressDeliveryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpressDeliveryMapper {

    ExpressDelivery toExpressDelivery(ResponseExpressDeliveryDto responseExpressDeliveryDto);
    ResponseExpressDeliveryDto toResponseExpressDeliveryDto(ExpressDelivery expressDelivery);
}
