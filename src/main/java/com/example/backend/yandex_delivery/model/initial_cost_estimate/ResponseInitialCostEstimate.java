package com.example.backend.yandex_delivery.model.initial_cost_estimate;

import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.CurrencyRules;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Requirements;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ResponseInitialCostEstimate {

    private CurrencyRules currency_rules;
    private int distance_meters;
    private int eta;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Requirements requirements;
    private String zone_id;
}