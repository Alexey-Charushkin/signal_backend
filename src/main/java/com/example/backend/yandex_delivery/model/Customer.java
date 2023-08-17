package com.example.backend.yandex_delivery.model;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
class Customer {
    @Email
    private String email; // Электронная почта пользователя в формате morty@yandex.ru.
    // Если не указано, будет использована почта получателя из точки
    private int inn; // ИНН пользователя (10 или 12 цифр)
    private int phone; // Телефон пользователя в формате +79990001122.
    // Если не указано, будет использован телефон получателя из точки


}
