package com.example.backend.yandex_delivery.geocoder.client;
import com.example.backend.yandex_delivery.geocoder.models.GeocoderResponse;
import org.springframework.http.ResponseEntity;

public interface DeliveryGeocode {
    ResponseEntity<GeocoderResponse> getGeocoderResponse(String address);
}
