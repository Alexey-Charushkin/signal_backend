package com.example.backend.yandex_delivery.exceptions;

public class GeocoderException extends RuntimeException {
    public GeocoderException(String message) {
        super(message);
    }
}
