package com.example.backend.yandex_delivery.model;

import com.example.backend.yandex_delivery.Contact;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoutePoint {
    @NotNull
    private Address address;
    private BuyOut buyout;
    @NotNull
    private Contact contact;
}
