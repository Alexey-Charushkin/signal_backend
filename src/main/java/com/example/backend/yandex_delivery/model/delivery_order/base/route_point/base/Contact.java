package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
    private String email;
    private String name;
    private String phone;
    private String phone_additional_code;
}
