package com.example.backend.yandex_delivery.service;

import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import reactor.core.publisher.Mono;

public interface YandexDeliveryService {
   ShortResponseDeliveryOrderDto saveDeliveryOrder(Long orderedDishId);

   ShortResponseDeliveryOrderDto findById(Long claim_Id);

   ShortResponseDeliveryOrderDto cancelById(Long claim_Id);
}
