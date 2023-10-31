package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AvailableTariff {
    // Доступные тарифы "Экспресс-доставки"
    private double minimal_price; //
    private String name;
    private List<SupportedRequirement> supported_requirements;
    private String text;
    private String title;
}