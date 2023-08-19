package com.example.backend.yandex_delivery.model.delivery_order.advanced.same_day_data;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SameDayData {
    //Опции доставки "В течение дня"
    @NotNull(message = "Установите интервал доставки")
    private DeliveryInterval delivery_interval;
}
