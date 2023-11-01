package com.example.backend.yandexdelivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Locality {
    @JsonProperty("LocalityName")
    private String localityName;
    @JsonProperty("Thoroughfare")
    private Thoroughfare thoroughfare;
}
