package com.example.backend.yandexdelivery.geocoder.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressComponent {
    private String kind;
    private String name;
}