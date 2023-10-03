package com.example.backend.yandex_delivery.model.delivery_order.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.base.DeliveryItem;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortDeliveryItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryItemMapper {
    DeliveryItem toDeliveryItem(ShortDeliveryItemDto shortDeliveryItemDto);

    ShortDeliveryItemDto toShortDeliveryItemDto(DeliveryItem deliveryItem);
}
