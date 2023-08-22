package com.example.backend.yandex_delivery.model.delivery_order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShortCargoDto {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String cost_currency;
    @NotNull
    private BigDecimal cost_value;
    private int droppof_point;
    @NotNull
    private int pickup_point;
    @NotNull
    private int quantity;
    @NotNull
    private String title;
}
