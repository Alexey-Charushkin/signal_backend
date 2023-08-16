package com.example.backend.yandex_delivery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
    private String email; // Email Ч об€зательный параметр дл€ точек source и return
    @NotNull
    @NotBlank
    private String name; // им€ контактного лица
    @NotNull
    private int phone; // “елефон контактного лица
    private int phone_additional_code; // ƒобавочный номер дл€ звонка курьера
}
