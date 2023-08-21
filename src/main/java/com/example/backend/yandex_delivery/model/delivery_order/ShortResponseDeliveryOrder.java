package com.example.backend.yandex_delivery.model.delivery_order;

import com.example.backend.yandex_delivery.model.delivery_order.base.Cargo;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ShortResponseDeliveryOrder {
    private long id; // Идентификатор заявки, полученный на этапе создания заявки
    private LocalDateTime created_ts; // дата и время создания
    private List<Cargo> items; // Перечисление наименований грузов для отправления
    private int revision;
    private List<RoutePoint> routePoints;
}
