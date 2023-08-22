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
    private String name; // ��� ����������� ����
    @NotNull
    private int phone; // ������� ����������� ����
}
