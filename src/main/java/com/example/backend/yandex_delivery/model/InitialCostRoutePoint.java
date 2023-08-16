package com.example.backend.yandex_delivery.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InitialCostRoutePoint {
    @NotNull(message = "Введите координаты точки маршрута")
    private double[] coordinates; //Координаты точки маршрута Массив из двух вещественных чисел [долгота, широта]. Порядок важен!
    @NotNull(message = "Введите адрес")
    @NotBlank(message = "Введите адрес")
    private String fullname; /* Полное название с указанием города (Москва, Садовническая набережная, 82с2).
     Важно вводить населенный пункт с указанием номера дома, но без номера квартиры, подъезда, этажа */
}
