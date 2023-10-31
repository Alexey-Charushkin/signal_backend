package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExpressDelivery {
    private boolean allowed; // "Экспресс-доставка" доступна
    private List<AvailableTariff> available_tariffs; // Доступные тарифы "Экспресс-доставки"
}
