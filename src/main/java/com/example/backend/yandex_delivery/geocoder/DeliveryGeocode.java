package com.example.backend.yandex_delivery.geocoder;

import org.springframework.http.ResponseEntity;

public interface DeliveryGeocode {
    ResponseEntity<String> getDeliveryCoordinates(String address);
}
