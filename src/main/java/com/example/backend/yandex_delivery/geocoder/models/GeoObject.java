package com.example.backend.yandex_delivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoObject {
    private GeocoderMetaData metaDataProperty;
    private String description;
    private String name;
    private BoundedBy boundedBy;
    private Point Point;
}

