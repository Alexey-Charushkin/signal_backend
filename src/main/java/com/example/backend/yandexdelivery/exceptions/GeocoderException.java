package com.example.backend.yandexdelivery.exceptions;

public class GeocoderException extends RuntimeException {
    public GeocoderException(String message) {
        super(message);
    }
}
