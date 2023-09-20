package com.example.backend.yandex_delivery.model.delivery_order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@Builder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortResponseDeliveryOrderDto {
    @NotNull
    @NotBlank
    private String id;
    @NotNull
    @NotBlank
    private String created_ts;
    @NotNull
    @NotBlank
    private String updated_ts; // (date-time)
    @NotNull
    private List<ShortDeliveryItemDto> items;
    @NotNull
    private int revision;
    @NotNull
    private List<ShortResponseRoutePointDto> route_points;
    @NotNull
    @NotBlank
    private String status;
    @NotNull
    @NotBlank
    private String user_request_revision;
    @NotNull
    private int version;
    private SameDayDataDto same_day_data;
    private boolean skip_client_notify;
}
