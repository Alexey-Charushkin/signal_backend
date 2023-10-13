package com.example.backend.yandex_delivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
public class GeoObjectResponse {
    private Response response;
   // private GeoObjectCollection response;
}

