package com.example.backend.yandexdelivery.geocoder.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeocoderResponseMetaData {
    private String request;
    private String found;
    private String results;
}
