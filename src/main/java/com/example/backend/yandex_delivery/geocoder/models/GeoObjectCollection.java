package com.example.backend.yandex_delivery.geocoder.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GeoObjectCollection {
    private MetaDataProperty metaDataProperty;
    private List<FeatureMember> featureMember;
}

