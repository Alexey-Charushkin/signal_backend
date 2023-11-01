package com.example.backend.yandexdelivery.repository;

import com.example.backend.yandexdelivery.model.deliveryorder.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YandexDeliveryRepository extends JpaRepository<DeliveryOrder, UUID> {

}
