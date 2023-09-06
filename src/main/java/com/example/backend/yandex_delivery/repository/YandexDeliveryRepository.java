package com.example.backend.yandex_delivery.repository;

import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YandexDeliveryRepository extends JpaRepository<DeliveryOrder, UUID> {

}
