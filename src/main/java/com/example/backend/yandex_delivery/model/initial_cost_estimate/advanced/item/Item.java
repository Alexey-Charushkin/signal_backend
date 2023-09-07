package com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.item;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    // Параметры предмета
    @NotNull(message = "Введите количество единиц товара")
    @Min(value = 1, message = "Количество единиц товара должно быть больше 0")
    private Integer quantity; // Количесто единиц товара minimum: 1
    Size size; //Линейные размеры предмета в метрах. Пример: 0.45
    float weight; // Вес в килограммах. Пример: 2.105
}
