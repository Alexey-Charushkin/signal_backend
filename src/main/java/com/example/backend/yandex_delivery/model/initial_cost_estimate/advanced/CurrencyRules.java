package com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyRules {
    @NotNull
    @NotBlank
    @Min(3)
    @Max(3)
    private String code;
    private String sign;
    @NotNull
    @NotBlank
    private String template;
    @NotNull
    @NotBlank
    private String text;
}
