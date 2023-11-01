package com.example.backend.yandexdelivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaDataProperty {
    @JsonProperty("GeocoderResponseMetaData")
    private GeocoderResponseMetaData geocoderResponseMetaData;
}