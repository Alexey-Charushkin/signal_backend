package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AvailableTariffDto {
    // Доступные тарифы "Экспресс-доставки"
    @NotNull
    private double minimal_price; //
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private List<SupportedRequirementDto> supported_requirements;
    @NotNull
    @NotBlank
    private String text;
    @NotNull
    @NotBlank
    private String title;
}

