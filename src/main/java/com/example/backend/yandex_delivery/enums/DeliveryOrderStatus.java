package com.example.backend.yandex_delivery.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DeliveryOrderStatus {
    // статус заказа на доставку
    NEW, // новый
    ESTIMATING, // оценка стоимости
    ESTIMATING_FAILED, // оценка стоимости не удалась
    READY_FOR_APPROVAL, // готов к подтверждению
    ACCEPTED, // подтверждён
    PERFORMER_LOOKUP, // поиск исполнителя
    PERFORMER_DRAFT, // исполнитель предварительно
    PERFORMER_FOUND, // исполнитель найден
    PERFORMER_NOT_FOUND, // исполнитель не найден
    PICKUP_ARRIVED, // автомобиль прибыл
    READY_FOR_PICKUP_CONFIRMATION, // готово для подтверждения прибытия
    PICKUPED, // готовиться
    DELIVERY_ARRIVED, // доставка прибыла
    READY_FOR_DELIVERY_CONFIRMATION, // готово для подтверждения прибытия доставки
    PAY_WAITING, // ожидание оплаты
    DELIVERED, // доставлено
    DELIVERED_FINISH, // доставка завершена
    RETURNING, // возвращается
    RETURN_ARRIVED, // возврат подтверждён
    READY_FOR_RETURN_CONFIRMATION, // готово для подтверждения возврата
    RETURNED, // возвращено
    RETURNED_FINISH, // возврат завершён
    FAILED, // неуспешно
    CANCELLED, // отменено
    CANCELED_WITH_PAYMENT, // отменено с оплатой
    CANCELED_BY_TAXI, // отменено в такси
    CANCELED_WITH_ITEMS_ON_BANDS // отменено с грузами на ленте
}
