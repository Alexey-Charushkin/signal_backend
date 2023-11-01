package com.example.backend.yandexdelivery.model.initialcostestimate.mapper;

import com.example.backend.yandexdelivery.model.initialcostestimate.dto.ShortRequestInitialCostEstimateDto;
import com.example.backend.yandexdelivery.model.initialcostestimate.dto.ShortResponseInitialCostEstimateDto;
import com.example.backend.yandexdelivery.model.initialcostestimate.InitialCostEstimate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InitialCostEstimateMapper {

    ShortRequestInitialCostEstimateDto toShortRequestInitialCostEstimateDto(InitialCostEstimate initialCostEstimate);

    InitialCostEstimate toInitialCostEstimate(ShortResponseInitialCostEstimateDto shortResponseInitialCostEstimateDto);
}
