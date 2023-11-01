package com.example.backend.yandexdelivery.geocoder.service;

import org.springframework.stereotype.Service;

@Service
public interface GeocoderService {
    double[] getDeliveryCoordinates (String address);
}
