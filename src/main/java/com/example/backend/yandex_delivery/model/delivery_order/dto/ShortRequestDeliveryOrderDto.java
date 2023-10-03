package com.example.backend.yandex_delivery.model.delivery_order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShortRequestDeliveryOrderDto {
    @NotNull
    private List<ShortDeliveryItemDto> items;
    @NotNull
    @Min(2)
    private List<ShortRequestRoutePointDto> route_points;
}
