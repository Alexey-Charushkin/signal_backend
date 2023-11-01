package com.example.backend.yandexdelivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Premise {
    @JsonProperty("PremiseNumber")
    private String premiseNumber;
    @JsonProperty("PostalCode")
    private PostalCode postalCode;
}