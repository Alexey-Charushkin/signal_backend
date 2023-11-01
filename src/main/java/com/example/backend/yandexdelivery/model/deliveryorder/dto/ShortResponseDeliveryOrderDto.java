package com.example.backend.yandexdelivery.model.deliveryorder.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortResponseDeliveryOrderDto {
    @NotNull
    @NotBlank
    private String id;
    private String uuid;
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
    @NotNull
    private SameDayDataDto same_day_data;
    @NotNull
    private boolean skip_client_notify;
    @NotNull
    @NotBlank
    private String available_cancel_state;

    public String getAvailable_cancel_state() {
        return available_cancel_state;
    }
}
