package com.example.backend.yandex_delivery.model.delivery_order.dto;

import com.example.backend.yandex_delivery.enums.DeliveryOrderStatus;
import com.example.backend.yandex_delivery.model.delivery_order.base.Cargo;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ShortResponseDeliveryOrderDto {
    @NotNull
    private long id;
    @NotNull
    private String created_ts;
    @NotNull
    private List<ShortCargoDto> items;
    @NotNull
    private int revision;
    @NotNull
    private List<ShortResponseRoutePointDto> routePoints;
    @NotNull
    @NotBlank
    private String status;
    @NotNull
    @NotBlank
    private String updated_ts; // (date-time)
    @NotNull
    @NotBlank
    private String user_request_revision;
    @NotNull
    private int version;
}
