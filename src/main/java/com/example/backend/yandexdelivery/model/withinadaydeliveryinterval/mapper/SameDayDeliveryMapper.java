package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.mapper;

import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model.SameDayDelivery;
import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto.SameDayDeliveryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SameDayDeliveryMapper {

    SameDayDelivery toSameDayDelivery(SameDayDeliveryDto sameDayDeliveryDto);

    SameDayDeliveryDto toSameDayDeliveryDto(SameDayDelivery sameDayDelivery);
}
