package com.example.backend.yandex_delivery.geocoder;

import com.example.backend.yandex_delivery.geocoder.models.GeoObjectResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryGeocodeIml implements DeliveryGeocode {
    private static final String apiKey = "9ee1bf60-ffbf-4229-96c8-8567ef288624";

    @Override
    public ResponseEntity<GeoObjectResponse> getDeliveryCoordinates(String address) {
        try {
           // String apiUrl = "https://geocode-maps.yandex.ru/1.x/?apikey="  + apiKey + "&format=json&geocode=" + address ;

            String apiUrl = "https://geocode-maps.yandex.ru/1.x/?apikey="  + apiKey + "&geocode=" + address + "&format=json";

           // https://geocode-maps.yandex.ru/1.x/?apikey=YOUR_API_KEY&geocode=Москва, улица Новый Арбат, дом 24&format=json

            RestTemplate restTemplate = new RestTemplate();

           // return restTemplate.getForEntity(apiUrl, String.class);
            ResponseEntity<GeoObjectResponse> response = restTemplate.getForEntity(apiUrl, GeoObjectResponse.class);
           // return restTemplate.getForEntity(apiUrl, GeoObjectResponse.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
          return (ResponseEntity<GeoObjectResponse>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);//.body("Error occurred while fetching delivery coordinates");
        }
    }

}
