package com.example.backend.yandex_delivery.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coordinates {
    // координаты точки маршрута
    @NotNull(message = "Введите координаты широты")
    private float latitude; // широта
    @NotNull(message = "Введите координаты долготы")
    private float longitude; // долгота
}
