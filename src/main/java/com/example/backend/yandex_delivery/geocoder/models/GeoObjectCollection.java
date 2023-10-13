package com.example.backend.yandex_delivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoObjectCollection {
    private String metaDataProperty;
    //  private List<FeatureMember> featureMember;
}
