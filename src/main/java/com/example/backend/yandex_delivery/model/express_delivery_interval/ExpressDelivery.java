package com.example.backend.yandex_delivery.model.express_delivery_interval;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExpressDelivery {
    private boolean allowed; // "Экспресс-доставка" доступна
    private List<AvailableTariff> available_tariffs; // Доступные тарифы "Экспресс-доставки"
}
