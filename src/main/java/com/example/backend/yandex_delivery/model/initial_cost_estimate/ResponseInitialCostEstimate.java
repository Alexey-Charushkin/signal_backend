package com.example.backend.yandex_delivery.model.initial_cost_estimate;

import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.CurrencyRules;
import com.example.backend.yandex_delivery.model.Requirements;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ResponseInitialCostEstimate {

    private CurrencyRules currency_rules;
    private int distance_meters; // Расстояние в метрах для маршрута, который был построен по точкам запроса, начиная с первой точки и заканчивая последней
    private int eta; // ETA в минутах, как пришло из /orders/estimate
    @NotNull
    private BigDecimal price; // Сумма в формате Decimal(18, 4)
    @NotNull
    private Requirements requirements; // Требования к доставке (класс авто, опции)
    private String zone_id; //
}