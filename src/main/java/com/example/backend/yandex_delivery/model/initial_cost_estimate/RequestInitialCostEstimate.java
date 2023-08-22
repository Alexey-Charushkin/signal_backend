package com.example.backend.yandex_delivery.model.initial_cost_estimate;

import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.item.Item;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.base.InitialCostRoutePoint;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Requirements;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RequestInitialCostEstimate {
    // Первичная оценка стоимости без создания заявки
    private List<Item> items;
    private Requirements client_requirements;
    @NotNull(message = "Введите адреса точек доставки")
    private List<InitialCostRoutePoint> route_points;
    private boolean skip_door_to_door; /* Отказ от доставки до двери (выключить опцию "От двери до двери").
    Возможные значения:
            true (курьер доставит заказ только на улицу, до подъезда)
            false (по умолчанию, доставка от двери до двери)
            */
}
