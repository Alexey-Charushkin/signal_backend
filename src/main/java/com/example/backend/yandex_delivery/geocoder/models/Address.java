package com.example.backend.yandex_delivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Address {
    private String country_code;
    private String postal_code;
    private String formatted;
    @JsonProperty("Components")
    private List<AddressComponent> components;
}
