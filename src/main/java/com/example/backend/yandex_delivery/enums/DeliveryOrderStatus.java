package com.example.backend.yandex_delivery.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DeliveryOrderStatus {
    NEW,
    ESTIMATING,
    ESTIMATING_FAILED,
    READY_FOR_APPROVAL,
    ACCEPTED,
    PERFORMER_LOOKUP,
    PERFORMER_DRAFT,
    PERFORMER_FOUND,
    PERFORMER_NOT_FOUND,
    PICKUP_ARRIVED,
    READY_FOR_PICKUP_CONFIRMATION,
    PICKUPED,
    DELIVERY_ARRIVED,
    READY_FOR_DELIVERY_CONFIRMATION,
    PAY_WAITING,
    DELIVERED,
    DELIVERED_FINISH,
    RETURNING,
    RETURN_ARRIVED,
    READY_FOR_RETURN_CONFIRMATION,
    RETURNED,
    RETURNED_FINISH,
    FAILED,
    CANCELLED,
    CANCELED_WITH_PAYMENT,
    CANCELED_BY_TAXI,
    CANCELED_WITH_ITEMS_ON_BANDS
}
