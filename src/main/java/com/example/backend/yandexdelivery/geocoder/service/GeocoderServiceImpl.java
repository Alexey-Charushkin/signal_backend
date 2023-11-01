package com.example.backend.yandexdelivery.geocoder.service;

import com.example.backend.yandexdelivery.geocoder.client.DeliveryGeocode;
import com.example.backend.yandexdelivery.geocoder.models.GeocoderResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class GeocoderServiceImpl implements GeocoderService {

    private final DeliveryGeocode geocode;

    @Override
    public double[] getDeliveryCoordinates(String address) {

        GeocoderResponse geocoderResponse = geocode.getGeocoderResponse(address).getBody();

        assert geocoderResponse != null;
        String points = geocoderResponse
                .getResponse()
                .getGeoObjectCollection()
                .getFeatureMember().get(0)
                .getGeoObject()
                .getPoint().getPos();

        try {
            return deserialize(points);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private double[] deserialize(String values) throws IOException {

        String[] parts = values.split(" ");
        double[] coordinates = new double[2];

        if (parts.length == 2) {
            coordinates[0] = Double.parseDouble(parts[0]);
            coordinates[1] = Double.parseDouble(parts[1]);
        }
        return coordinates;
    }
}

