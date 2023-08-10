package com.example.backend.yandex_delivery.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Requirements {
    // Требования к доставке (класс авто, опции)
    private boolean assign_robot;
    private Integer cargo_loaders; // Число грузчиков для грузового тарифа. Возможные значения: 0, 1, 2.
    private List<CargoOptions> cargo_options; /* Список дополнительных опций тарифа. Возможные отдельные опции:
    auto_courier (курьер только на машине), thermobag (курьер с термосумкой), Пример списка опций: ["auto_courier"].
    Точный список возможных значений для конкретной геоточки уточните с помощью метода получения тарифов v1/tariffs */
    private CargoType cargo_type;/* Тип (размер) кузова для грузового тарифа. Возможные значения:
    van ("Маленький кузов"), lcv_m ("Средний кузов"), lcv_l ("Большой кузов").
    Точный список возможных значений для конкретной геоточки уточните с помощью метода получения тарифов v2/tariffs */
    private boolean pro_courier; // Опция "Профи" для тарифов "Экспресс" и "Курьер"
    private TaxiClass taxi_class; // класс такси   пример: "express"
}

enum CargoOptions {
    AUTO_COURIER,
    THERMOBAG
}

enum CargoType {
    VAN,
    LCV_M,
    LCV_L
}

enum TaxiClass {
    EXPRESS
}