package com.example.backend.yandex_delivery.model.initial_cost_estimate.dto;

import com.example.backend.yandex_delivery.model.Requirements;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShortResponseInitialCostEstimateDto {
    @NotNull
    private BigDecimal price; // Сумма в формате Decimal(18, 4)
    @NotNull
    private Requirements requirements; // Требования к доставке (класс авто, опции)
}