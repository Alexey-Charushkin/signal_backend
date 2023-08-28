package com.example.backend.yandex_delivery.repository;

import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YandexDeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {


}
