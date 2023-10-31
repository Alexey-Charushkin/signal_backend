package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.mapper;

import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.model.WithDayDelivery;
import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto.ResponseWithDayDeliveryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WithDayDeliveryMapper {

    WithDayDelivery toWithDayDelivery(ResponseWithDayDeliveryDto responseWithDayDeliveryDto);

    ResponseWithDayDeliveryDto toResponseWithDayDeliveryDto(WithDayDelivery withDayDelivery);
}
