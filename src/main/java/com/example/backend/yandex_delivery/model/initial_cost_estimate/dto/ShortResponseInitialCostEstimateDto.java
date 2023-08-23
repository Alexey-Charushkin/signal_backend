package com.example.backend.yandex_delivery.model.initial_cost_estimate.dto;

import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Requirements;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShortResponseInitialCostEstimateDto {
    @NotNull
    private BigDecimal price; // Decimal(18, 4)
    @NotNull
    private Requirements requirements; }