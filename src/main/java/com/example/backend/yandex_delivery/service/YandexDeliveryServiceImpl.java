package com.example.backend.yandex_delivery.service;

import com.example.backend.yandex_delivery.client.YandexDeliveryWebClient;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class YandexDeliveryServiceImpl implements YandexDeliveryService {

    private final YandexDeliveryWebClient client;

    @Override
    public ShortResponseDeliveryOrderDto saveDeliveryOrder(ShortRequestDeliveryOrderDto dto) {
        UUID uuid = UUID.randomUUID();
        String path = "create?request_id=" + 1000000000;

        return client.saveDeliveryOrder(path, dto).block();

    }
}
