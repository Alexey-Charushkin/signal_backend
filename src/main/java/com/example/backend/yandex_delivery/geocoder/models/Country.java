package com.example.backend.yandex_delivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private String AddressLine;
    private String CountryNameCode;
    private String CountryName;
    private AdministrativeArea AdministrativeArea;
}
