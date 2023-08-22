package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ExternalOrderCost {

    @NotNull
    @NotBlank
    private String currency;
    @NotNull
    @NotBlank
    private String currency_sign;
    @NotNull
    private BigDecimal value;
}
