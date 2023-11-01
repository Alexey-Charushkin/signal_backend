package com.example.backend.yandexdelivery.service;

import com.example.backend.yandexdelivery.model.deliveryorder.dto.ShortResponseDeliveryOrderDto;
import com.example.backend.yandexdelivery.model.initialcostestimate.dto.ShortResponseInitialCostEstimateDto;

public interface YandexDeliveryService {
    ShortResponseDeliveryOrderDto saveDeliveryOrder(Long orderedDishId);

    ShortResponseDeliveryOrderDto findById(Long id);

    ShortResponseDeliveryOrderDto cancelById(Long claim_Id);

    ShortResponseDeliveryOrderDto acceptById(Long claim_Id);

    ShortResponseInitialCostEstimateDto getPrimaryCost(Long orderedDishId);
}
