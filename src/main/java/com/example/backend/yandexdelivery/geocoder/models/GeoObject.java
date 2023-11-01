package com.example.backend.yandexdelivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeoObject {
    private MetaDataProperty2 metaDataProperty;
    private String description;
    private String name;
    private BoundedBy boundedBy;
    private String uri;
    @JsonProperty("Point")
    private Point point;
}
