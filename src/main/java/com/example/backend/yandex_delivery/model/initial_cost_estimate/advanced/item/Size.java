package com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.item;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Size {
    // Линейные размеры предмета в метрах. Пример: 0.45
    @NotNull(message = "Установите высоту коробки")
    private float height;
    @NotNull(message = "Установите длину коробки")
    private float length;
    @NotNull(message = "Установите ширину коробки")
    private float width;
}
