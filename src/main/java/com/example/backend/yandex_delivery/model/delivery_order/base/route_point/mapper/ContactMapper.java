package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Contact;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortContactDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toContact(ShortContactDto shortContactDto);

    ShortContactDto toShortContactDto(Contact contact);
}
