package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    @Email
    private String email;
    private int inn;
    private int phone;
}
