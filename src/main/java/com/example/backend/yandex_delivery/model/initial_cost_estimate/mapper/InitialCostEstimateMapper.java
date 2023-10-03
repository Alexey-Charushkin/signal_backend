package com.example.backend.yandex_delivery.model.initial_cost_estimate.mapper;

import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortRequestInitialCostEstimateDto;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortResponseInitialCostEstimateDto;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.InitialCostEstimate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InitialCostEstimateMapper {

    ShortRequestInitialCostEstimateDto toShortRequestInitialCostEstimateDto(InitialCostEstimate initialCostEstimate);

    InitialCostEstimate toInitialCostEstimate(ShortResponseInitialCostEstimateDto shortResponseInitialCostEstimateDto);
}
