package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.mapper;

import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model.WithDayDelivery;
import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto.ResponseWithDayDeliveryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WithDayDeliveryMapper {

    WithDayDelivery toWithDayDelivery(ResponseWithDayDeliveryDto responseWithDayDeliveryDto);

    ResponseWithDayDeliveryDto toResponseWithDayDeliveryDto(WithDayDelivery withDayDelivery);
}
