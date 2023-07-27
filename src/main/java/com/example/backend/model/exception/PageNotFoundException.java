package com.example.backend.model.exception;

public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException(Long id) {
        super("Страница с id:" + id + " не найдена");
    }
}
