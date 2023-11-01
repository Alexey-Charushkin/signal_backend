package com.example.backend.yandexdelivery.model.deliveryorder.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ExternalOrderCostDto {
    @NotNull
    @NotBlank
    private String currency;
    @NotNull
    @NotBlank
    private String currency_sign;
    @NotNull
    private BigDecimal value;
}
