package com.example.backend.yandexdelivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Thoroughfare {
    @JsonProperty("ThoroughfareName")
    private String thoroughfareName;
    @JsonProperty("Premise")
    private Premise premise;
}
