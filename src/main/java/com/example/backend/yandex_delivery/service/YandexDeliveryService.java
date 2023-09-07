package com.example.backend.yandex_delivery.service;

import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortResponseInitialCostEstimateDto;

public interface YandexDeliveryService {
    ShortResponseDeliveryOrderDto saveDeliveryOrder(Long orderedDishId);

    ShortResponseDeliveryOrderDto findById(String claim_Id);

    ShortResponseDeliveryOrderDto cancelById(String claim_Id);

    ShortResponseDeliveryOrderDto acceptById(String claim_Id);

    ShortResponseInitialCostEstimateDto getPrimaryCost(Long orderedDishId);
}
