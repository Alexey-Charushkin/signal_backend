package com.example.backend.yandexdelivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    @JsonProperty("GeoObjectCollection")
    private GeoObjectCollection geoObjectCollection;
}

