package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.mapper;

import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.AvailableTariff;
import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto.AvailableTariffDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvailableTariffMapper {

    AvailableTariff toAvailableTariff(AvailableTariffDto availableTariffDto);
    AvailableTariffDto toResponseAvailableTariffDto(AvailableTariff availableTariff);
}
