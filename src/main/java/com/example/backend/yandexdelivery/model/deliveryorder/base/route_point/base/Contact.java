package com.example.backend.yandexdelivery.model.deliveryorder.base.route_point.base;

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
