package com.example.backend.yandexdelivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeocoderMetaData {
    private String kind;
    private String text;
    private String precision;
    @JsonProperty("Address")
    private Address address;
    @JsonProperty("AddressDetails")
    private AddressDetails addressDetails;
}
