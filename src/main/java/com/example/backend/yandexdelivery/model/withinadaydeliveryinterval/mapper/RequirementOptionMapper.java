package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.mapper;

import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model.RequirementOption;
import com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto.RequirementOptionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementOptionMapper {

    RequirementOption toRequirementOption(RequirementOptionDto requirementOptionDto);

    RequirementOptionDto toRequirementOptionDto(RequirementOption requirementOption);
}
