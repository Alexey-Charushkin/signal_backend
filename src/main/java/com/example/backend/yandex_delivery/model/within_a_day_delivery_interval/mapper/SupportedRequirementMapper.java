package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.mapper;

import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.model.SupportedRequirement;
import com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto.SupportedRequirementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupportedRequirementMapper {

    SupportedRequirement toSupportedRequirement(SupportedRequirementDto supportedRequirementDto);

    @Mapping(target = "type", expression = "java(supportedRequirement.getType().name().toLowerCase())")
    SupportedRequirementDto toSupportedRequirementDto(SupportedRequirement supportedRequirement);
}
