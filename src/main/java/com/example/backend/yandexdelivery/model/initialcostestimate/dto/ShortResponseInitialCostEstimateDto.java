package com.example.backend.yandexdelivery.model.initialcostestimate.dto;

import com.example.backend.yandexdelivery.model.deliveryorder.base.route_point.base.Requirements;
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
    private Requirements requirements;
}