package com.example.backend.yandexdelivery.enums;

public enum VisitStatus {
    // статус посещения
    PENDING, // ожидание
    ARRIVED, // прибыл в точку маршрута
    VISITED, // посещено
    PARTIAL_DELIVERY, // частичная поставка
    SKIPPED // пропущено
}
