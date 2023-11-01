package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto;

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
