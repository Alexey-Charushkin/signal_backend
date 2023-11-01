package com.example.backend.yandexdelivery.model.deliveryorder.advanced.same_day_data;

import com.example.backend.yandexdelivery.model.deliveryorder.base.DeliveryInterval;
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
