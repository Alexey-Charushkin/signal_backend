package com.example.backend.yandex_delivery.model.delivery_order.dto;

import com.example.backend.yandex_delivery.enums.DeliveryOrderStatus;
import com.example.backend.yandex_delivery.model.delivery_order.base.Cargo;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ShortResponseDeliveryOrderDto {
    @NotNull
    private long id; // Идентификатор заявки, полученный на этапе создания заявки
    @NotNull
    private LocalDateTime created_ts; // дата и время создания
    @NotNull
    private List<Cargo> items; // Перечисление наименований грузов для отправления
    @NotNull
    private int revision;
    @NotNull
    private List<RoutePoint> routePoints;
    @NotNull
    private DeliveryOrderStatus status; // Статус заявки
    @NotNull
    private LocalDateTime updated_ts; // (date-time) Дата-время последнего обновления
    @NotNull
    private String user_request_revision; // Текущая версия изменений в заявке от пользователя
    @NotNull
    private int version; // версия
}
