package com.example.backend.yandex_delivery.model.delivery_order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ShortContactDto {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String phone;
}
