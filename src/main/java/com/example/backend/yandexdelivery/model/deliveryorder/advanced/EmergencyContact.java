package com.example.backend.yandexdelivery.model.deliveryorder.advanced;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmergencyContact {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String phone;
    private String phone_additional_code;
}