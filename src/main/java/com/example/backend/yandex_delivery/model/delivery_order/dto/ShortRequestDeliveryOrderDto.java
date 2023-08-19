package com.example.backend.yandex_delivery.model.delivery_order.dto;

import com.example.backend.yandex_delivery.model.delivery_order.base.Cargo;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShortRequestDeliveryOrderDto {
    // Короткий запрос на создание заявки на доставку. Только обязательные параметры
    @NotNull
    private List<Cargo> items; // Перечисление наименований грузов для отправления
    @NotNull
    private List<RoutePoint> route_points; // Информация по точкам маршрута
}
