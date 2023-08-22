package com.example.backend.yandex_delivery.model.delivery_order.base;

import com.example.backend.yandex_delivery.model.delivery_order.advanced.fiscalization.Fiscalization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Data
@Builder
public class Cargo {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String cost_currency;
    @NotNull
    private BigDecimal cost_value;
    @NotNull
    private int droppof_point;

    private int extra_id;
    private Fiscalization fiscalization;
    @NotNull
    private int pickup_point;
    @NotNull
    private int quantity;
    private Size size;
    @NotNull
    private String title;
}
