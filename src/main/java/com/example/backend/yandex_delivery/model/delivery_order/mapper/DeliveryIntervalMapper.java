package com.example.backend.yandex_delivery.model.delivery_order.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.base.DeliveryInterval;
import com.example.backend.yandex_delivery.model.delivery_order.dto.DeliveryIntervalDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryIntervalMapper {

    // @Mapping(target="from", source = "DeliveryIntervalDto.from", dateFormat = "dd-MM-yyyy HH:mm:ss")
//    @Mapping(target="to", source = "DeliveryIntervalDto.to", dateFormat = "dd-MM-yyyy HH:mm:ss")
    DeliveryInterval toDeliveryInterval(DeliveryIntervalDto deliveryIntervalDto);

    DeliveryIntervalDto toDeliveryIntervalDto(DeliveryInterval deliveryInterval);

}
