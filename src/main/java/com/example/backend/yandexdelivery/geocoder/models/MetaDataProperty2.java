package com.example.backend.yandexdelivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaDataProperty2 {
    @JsonProperty("GeocoderMetaData")
    private GeocoderMetaData geocoderMetaData;
}