package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.mapper;

import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.model.SameDayDelivery;
import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto.SameDayDeliveryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SameDayDeliveryMapper {

    SameDayDelivery toSameDayDelivery(SameDayDeliveryDto sameDayDeliveryDto);

    SameDayDeliveryDto toSameDayDeliveryDto(SameDayDelivery sameDayDelivery);
}
