package com.example.backend.yandex_delivery.geocoder;

import com.example.backend.yandex_delivery.geocoder.models.GeoObjectResponse;
import org.springframework.http.ResponseEntity;

public interface DeliveryGeocode {
    ResponseEntity<GeoObjectResponse> getDeliveryCoordinates(String address);
}
