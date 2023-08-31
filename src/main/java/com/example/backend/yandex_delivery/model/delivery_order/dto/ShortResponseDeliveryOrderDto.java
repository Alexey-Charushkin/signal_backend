package com.example.backend.yandex_delivery.model.delivery_order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShortResponseDeliveryOrderDto {
    @NotNull
    private long id;
    @NotNull
    private String created_ts;
    @NotNull
    private List<ShortDeliveryItemDto> items;
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
    private SameDayDataDto same_day_data;
    private boolean skip_client_notify;
}
