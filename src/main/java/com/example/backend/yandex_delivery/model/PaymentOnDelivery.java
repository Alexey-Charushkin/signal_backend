package com.example.backend.yandex_delivery.model;

import com.example.backend.yandex_delivery.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentOnDelivery {
    private Customer customer;
    @NotNull
    private PaymentMethod payment_method;

}
