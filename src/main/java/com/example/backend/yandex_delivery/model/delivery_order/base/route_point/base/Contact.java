package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
    private String email;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private long phone;
    private long phone_additional_code;
}
