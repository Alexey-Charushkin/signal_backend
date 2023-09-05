package com.example.backend.yandex_delivery.model.delivery_order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DeliveryIntervalDto {
    // временой диапазон доставки в течении дня
    @NotNull(message = "Установите начало диапаззона времени доставки")
    @NotBlank
    private String from; // (date-time)  Начало интервала (UTC)
    @NotNull(message = "Установите конец диапаззона времени доставки")
    @NotBlank
    private String to; // (date-time)  Окончание интервала (UTC)
}
