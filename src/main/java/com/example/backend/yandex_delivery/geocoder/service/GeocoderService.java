package com.example.backend.yandex_delivery.geocoder.service;

import org.springframework.stereotype.Service;

@Service
public interface GeocoderService {
    double[] getDeliveryCoordinates (String address);
}
