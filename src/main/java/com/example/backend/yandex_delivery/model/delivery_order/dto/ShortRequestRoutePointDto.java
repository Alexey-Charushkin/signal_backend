package com.example.backend.yandex_delivery.model.delivery_order.dto;

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
    private int point_id;
    @NotNull
    private String type;
    @NotNull
    private int visit_order;
    @NotNull
    private String visit_status;
}
