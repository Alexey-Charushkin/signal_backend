package com.example.backend.yandex_delivery.model.initial_cost_estimate.dto;

import com.example.backend.yandex_delivery.model.initial_cost_estimate.base.InitialCostRoutePoint;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShortRequestInitialCostEstimateDto {
    // Первичная оценка стоимости без создания заявки. Короткий запрос содержит только обязательные поля.
    @NotNull(message = "Введите адреса точек доставки")
    private List<InitialCostRoutePoint> route_points;
}
