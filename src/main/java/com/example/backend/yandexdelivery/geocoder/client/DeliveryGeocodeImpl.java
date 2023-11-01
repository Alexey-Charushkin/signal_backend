package com.example.backend.yandexdelivery.geocoder.client;

import com.example.backend.yandexdelivery.exceptions.GeocoderException;
import com.example.backend.yandexdelivery.geocoder.models.GeocoderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryGeocodeImpl implements DeliveryGeocode {
    private static final String apiKey = "9ee1bf60-ffbf-4229-96c8-8567ef288624";
    RestTemplate restTemplate;

    private RestTemplate getRestTemplate() {
        if( restTemplate == null) {
            restTemplate = new RestTemplate();
        }
        return restTemplate;
    }

    @Override
    public ResponseEntity<GeocoderResponse> getGeocoderResponse(String address) {
        try {
            String apiUrl = "https://geocode-maps.yandex.ru/1.x/?apikey=" + apiKey + "&geocode=" + address + "&format=json";

           RestTemplate restTemplate = getRestTemplate();

            return restTemplate.getForEntity(apiUrl, GeocoderResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeocoderException("Error occurred while fetching delivery coordinates");
        }
    }
}
