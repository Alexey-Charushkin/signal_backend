package com.example.backend.yandexdelivery.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {

        super(message);
    }
}
