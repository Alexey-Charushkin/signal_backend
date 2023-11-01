package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.mapper;

import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model.AvailableTariff;
import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto.AvailableTariffDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvailableTariffMapper {

    AvailableTariff toAvailableTariff(AvailableTariffDto availableTariffDto);

    AvailableTariffDto toResponseAvailableTariffDto(AvailableTariff availableTariff);
}
