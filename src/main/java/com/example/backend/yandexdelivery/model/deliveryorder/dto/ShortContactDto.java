package com.example.backend.yandexdelivery.model.deliveryorder.dto;

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
