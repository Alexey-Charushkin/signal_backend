package com.example.backend.yandex_delivery.geocoder.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Envelope {
    private String lowerCorner;
    private String upperCorner;
}
