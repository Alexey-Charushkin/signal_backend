package com.example.backend.yandex_delivery.model.delivery_order.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SameDayDataDto {
    //Опции доставки "В течение дня"
    @NotNull(message = "Установите интервал доставки")
    private DeliveryIntervalDto delivery_interval;
}
