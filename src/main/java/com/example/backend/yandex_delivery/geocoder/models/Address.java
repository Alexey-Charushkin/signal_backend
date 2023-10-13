package com.example.backend.yandex_delivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String country_code;
    private String postal_code;
    private String formatted;
    private List<AddressComponent> Components;
}

