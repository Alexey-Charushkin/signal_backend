package com.example.backend.yandex_delivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class GeocoderResponseMetaData {
    private String request;
    private String found;
    private String results;
}

