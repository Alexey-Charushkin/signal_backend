package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.mapper;

import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.model.RequirementOption;
import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto.RequirementOptionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementOptionMapper {

    RequirementOption toRequirementOption(RequirementOptionDto requirementOptionDto);

    RequirementOptionDto toRequirementOptionDto(RequirementOption requirementOption);
}
