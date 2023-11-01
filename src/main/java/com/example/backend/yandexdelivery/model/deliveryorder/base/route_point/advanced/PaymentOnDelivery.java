package com.example.backend.yandexdelivery.model.deliveryorder.base.route_point.advanced;

import com.example.backend.yandexdelivery.enums.PaymentMethod;
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
