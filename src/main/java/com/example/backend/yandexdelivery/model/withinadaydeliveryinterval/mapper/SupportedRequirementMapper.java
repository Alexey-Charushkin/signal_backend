package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.mapper;

import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model.SupportedRequirement;
import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto.SupportedRequirementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupportedRequirementMapper {

    SupportedRequirement toSupportedRequirement(SupportedRequirementDto supportedRequirementDto);

    @Mapping(target = "type", expression = "java(supportedRequirement.getType().name().toLowerCase())")
    SupportedRequirementDto toSupportedRequirementDto(SupportedRequirement supportedRequirement);
}
