package com.example.backend.yandex_delivery.model.delivery_order.advanced.fiscalization;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mark {
    @NotNull
    @NotBlank
    private String code;
    @NotNull
    @NotBlank
    private String kind;
}
