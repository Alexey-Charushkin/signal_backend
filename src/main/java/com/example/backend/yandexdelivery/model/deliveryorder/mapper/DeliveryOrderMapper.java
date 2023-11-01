package com.example.backend.yandexdelivery.model.deliveryorder.mapper;

import com.example.backend.yandexdelivery.model.deliveryorder.DeliveryOrder;
import com.example.backend.yandexdelivery.model.deliveryorder.advanced.same_day_data.SameDayData;
import com.example.backend.yandexdelivery.model.deliveryorder.base.DeliveryInterval;
import com.example.backend.yandexdelivery.model.deliveryorder.base.DeliveryItem;
import com.example.backend.yandexdelivery.model.deliveryorder.base.route_point.RoutePoint;
import com.example.backend.yandexdelivery.model.deliveryorder.base.route_point.base.Address;
import com.example.backend.yandexdelivery.model.deliveryorder.base.route_point.base.Contact;
import com.example.backend.yandexdelivery.model.deliveryorder.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryOrderMapper {

    @Mapping(target = "created_ts", source = "shortResponseDeliveryOrderDto.created_ts", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    @Mapping(target = "updated_ts", source = "shortResponseDeliveryOrderDto.updated_ts", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    @Mapping(target = "status", expression = "java(com.example.backend.yandex_delivery.enums.DeliveryOrderStatus." +
            "valueOf(shortResponseDeliveryOrderDto.getStatus().toUpperCase()))")
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "available_cancel_state", expression = "java(com.example.backend.yandex_delivery.enums.CancelState." +
            "valueOf(shortResponseDeliveryOrderDto.getAvailable_cancel_state().toUpperCase()))")
    DeliveryOrder toDeliveryOrder(ShortResponseDeliveryOrderDto shortResponseDeliveryOrderDto);

    ShortRequestDeliveryOrderDto toShortRequestDeliveryOrderDto(DeliveryOrder deliveryOrder);

    @Mapping(target = "cancel_state", expression = "java(deliveryOrder.getAvailable_cancel_state().name().toLowerCase())")
    CancelDto toCancelDto(DeliveryOrder deliveryOrder);

    AcceptDto toAcceptDto(DeliveryOrder deliveryOrder);

    @Mapping(target = "type", expression = "java(com.example.backend.yandex_delivery.enums.RoutePointType." +
            "valueOf(shortResponseRoutePointDto.getType().toUpperCase()))")
    @Mapping(target = "visit_status", expression = "java(com.example.backend.yandex_delivery.enums." +
            "VisitStatus.valueOf(shortResponseRoutePointDto.getVisitStatus().toUpperCase()))")
    RoutePoint toRoutePoint(ShortResponseRoutePointDto shortResponseRoutePointDto);

    @Mapping(target = "type", expression = "java(routePoint.getType().name().toLowerCase())")
    ShortRequestRoutePointDto toShortRoutePointDto(RoutePoint routePoint);

    Address toAddress(ShortAddressDto shortAddressDto);

    ShortAddressDto toShortAddressDto(Address address);

    Contact toContact(ShortContactDto shortContactDto);

    ShortContactDto toShortContactDto(Contact contact);

    @Mapping(target="from", source = "deliveryIntervalDto.from", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    @Mapping(target="to", source = "deliveryIntervalDto.to", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    DeliveryInterval toDeliveryInterval(DeliveryIntervalDto deliveryIntervalDto);

    DeliveryIntervalDto toDeliveryIntervalDto(DeliveryInterval deliveryInterval);

    DeliveryItem toDeliveryItem(ShortDeliveryItemDto shortDeliveryItemDto);

    ShortDeliveryItemDto toShortDeliveryItemDto(DeliveryItem deliveryItem);

    SameDayData toSameDayData(SameDayDataDto sameDayDataDto);

    SameDayDataDto toSameDayDataDto(SameDayData sameDayData);
}
