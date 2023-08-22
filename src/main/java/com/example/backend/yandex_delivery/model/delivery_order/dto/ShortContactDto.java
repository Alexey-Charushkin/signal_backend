package com.example.backend.yandex_delivery.model.delivery_order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShortContactDto {
    @NotNull
    @NotBlank
    private String name; // имя контактного лица
    @NotNull
    private int phone; // Телефон контактного лица
}
