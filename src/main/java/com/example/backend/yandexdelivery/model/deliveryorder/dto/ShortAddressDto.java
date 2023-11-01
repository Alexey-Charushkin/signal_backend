package com.example.backend.yandexdelivery.model.deliveryorder.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortAddressDto {
    @NotNull(message = "Введите координаты точки маршрута")
    private double[] coordinates; // масссив из двух вещественных чисел. Широта и долгота. Порядок важен.
    @NotNull(message = "Введите адрес точки маршрута")
    @NotBlank(message = "Введите адрес точки маршрута")
    private String fullname; /* Полное название с указанием города (Москва, Садовническая набережная, 82с2).
     Важно вводить населенный пункт с указанием номера дома, но без номера квартиры, подъезда, этажа*/
    private String shortname;
    @NotNull
    @NotBlank
    String uri;
}
