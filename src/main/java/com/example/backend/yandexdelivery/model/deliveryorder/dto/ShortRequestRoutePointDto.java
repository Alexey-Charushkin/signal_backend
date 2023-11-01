package com.example.backend.yandexdelivery.model.deliveryorder.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShortRequestRoutePointDto {
    @NotNull
    private ShortAddressDto address;
    @NotNull
    private ShortContactDto contact;
    @NotNull
    private long point_id;
    @NotNull
    private String type;
    @NotNull
    private int visit_order;
}
