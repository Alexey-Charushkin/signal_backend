package com.example.backend.yandex_delivery.model.delivery_order.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShortRequestDeliveryOrderDto {
    @NotNull
    private List<ShortCargoDto> items;
    @NotNull
    private List<ShortRequestRoutePointDto> route_points;
}
