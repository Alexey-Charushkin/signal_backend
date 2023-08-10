package com.example.backend.yandex_delivery.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DeliveryInterval {
    // временой диапазон доставки в течении дня
    @NotNull(message = "Установите начало диапаззона времени доставки")
    private LocalDateTime from; // (date-time)  Начало интервала (UTC)
    @NotNull(message = "Установите конец диапаззона времени доставки")
    private LocalDateTime to; // (date-time)  Окончание интервала (UTC)
}
