package com.example.backend.yandex_delivery.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DeliveryInterval {
    // временой диапазон доставки в течении дня
    @NotNull(message = "Установите начало диапаззона времени доставки")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime from; // (date-time)  Начало интервала (UTC)
    @NotNull(message = "Установите конец диапаззона времени доставки")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime to; // (date-time)  Окончание интервала (UTC)
}
