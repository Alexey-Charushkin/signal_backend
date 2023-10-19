package com.example.backend.yandex_delivery.geocoder.models;

import com.example.backend.yandex_delivery.geocoder.models.AdministrativeArea;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Country {
    @JsonProperty("AddressLine")
    private String addressLine;
    @JsonProperty("CountryNameCode")
    private String countryNameCode;
    @JsonProperty("CountryName")
    private String countryName;
    @JsonProperty("AdministrativeArea")
    private AdministrativeArea administrativeArea;

}
