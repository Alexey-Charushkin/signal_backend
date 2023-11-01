package com.example.backend.yandexdelivery.geocoder.client;
import com.example.backend.yandexdelivery.geocoder.models.GeocoderResponse;
import org.springframework.http.ResponseEntity;

public interface DeliveryGeocode {
    ResponseEntity<GeocoderResponse> getGeocoderResponse(String address);
}
