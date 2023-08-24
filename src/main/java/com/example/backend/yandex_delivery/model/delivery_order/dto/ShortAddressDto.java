package com.example.backend.yandex_delivery.model.delivery_order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShortAddressDto {
    @NotNull(message = "Введите координаты точки маршрута")
    private double[] coordinates; // масссив из двух вещественных чисел. Широта и долгота. Порядок важен.
    @NotNull(message = "Введите адрес точки маршрута")
    @NotBlank(message = "Введите адрес точки маршрута")
    private String fullname; /* Полное название с указанием города (Москва, Садовническая набережная, 82с2).
     Важно вводить населенный пункт с указанием номера дома, но без номера квартиры, подъезда, этажа*/
}
