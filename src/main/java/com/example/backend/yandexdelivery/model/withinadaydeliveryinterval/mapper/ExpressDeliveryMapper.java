package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.mapper;

import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model.ExpressDelivery;
import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto.ExpressDeliveryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpressDeliveryMapper {

    ExpressDelivery toExpressDelivery(ExpressDeliveryDto expressDeliveryDto);

    ExpressDeliveryDto toResponseExpressDeliveryDto(ExpressDelivery expressDelivery);
}
