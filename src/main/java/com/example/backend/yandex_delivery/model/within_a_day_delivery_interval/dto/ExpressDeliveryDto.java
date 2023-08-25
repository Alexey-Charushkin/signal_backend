package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExpressDeliveryDto {
    @NotNull
    private boolean allowed; // "Экспресс-доставка" доступна
    @NotNull
    private List<AvailableTariffDto> available_tariffs; // Доступные тарифы "Экспресс-доставки"
}
