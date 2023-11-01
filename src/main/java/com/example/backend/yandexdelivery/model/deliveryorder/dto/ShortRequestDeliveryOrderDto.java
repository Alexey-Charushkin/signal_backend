package com.example.backend.yandexdelivery.model.deliveryorder.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
