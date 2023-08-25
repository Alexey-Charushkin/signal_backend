package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.mapper;

import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.ExpressDelivery;
import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto.ExpressDeliveryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpressDeliveryMapper {

    ExpressDelivery toExpressDelivery(ExpressDeliveryDto expressDeliveryDto);
    ExpressDeliveryDto toResponseExpressDeliveryDto(ExpressDelivery expressDelivery);
}
