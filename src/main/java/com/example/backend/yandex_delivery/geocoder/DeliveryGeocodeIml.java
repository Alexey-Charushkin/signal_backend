package com.example.backend.yandex_delivery.geocoder;

import com.example.backend.yandex_delivery.geocoder.models.GeocoderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryGeocodeIml implements DeliveryGeocode {
    private static final String apiKey = "9ee1bf60-ffbf-4229-96c8-8567ef288624";

    @Override
    public ResponseEntity<GeocoderResponse> getDeliveryCoordinates(String address) {
        try {
            String apiUrl = "https://geocode-maps.yandex.ru/1.x/?apikey=" + apiKey + "&geocode=" + address + "&format=json";

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<GeocoderResponse> response = restTemplate.getForEntity(apiUrl, GeocoderResponse.class);
            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<GeocoderResponse>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);//.body("Error occurred while fetching delivery coordinates");
        }
    }
}
