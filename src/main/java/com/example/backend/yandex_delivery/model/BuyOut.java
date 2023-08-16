package com.example.backend.yandex_delivery.model;

import com.example.backend.yandex_delivery.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
class BuyOut {
    @NotNull
    private PaymentMethod payment_method; // Выбранный тип оплаты. card - оплата картой с fallback на ссылку;
    // cash - оплата наличными (пока недоступна);
}
