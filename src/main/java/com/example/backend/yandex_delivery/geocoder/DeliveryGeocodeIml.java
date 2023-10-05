package com.example.backend.yandex_delivery.geocoder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryGeocodeIml implements DeliveryGeocode {
    private static final String apiKey = "9ee1bf60-ffbf-4229-96c8-8567ef288624";

    @Override
    public ResponseEntity<String> getDeliveryCoordinates(String address) {
        try {
            String apiUrl = "https://geocode-maps.yandex.ru/1.x/?apikey="  + apiKey + "&format=json&geocode=" + address ;

            RestTemplate restTemplate = new RestTemplate();

            return restTemplate.getForEntity(apiUrl, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching delivery coordinates");
        }
    }
}
