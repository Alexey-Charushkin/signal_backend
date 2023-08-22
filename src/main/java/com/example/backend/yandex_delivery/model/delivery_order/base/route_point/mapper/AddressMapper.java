package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.mapper;

import com.example.backend.model.MainPageData;
import com.example.backend.model.dto.MainPageDataDTO;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Address;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortAddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(ShortAddressDto shortAddressDto);

    ShortAddressDto toShortAddressDto(Address address);
}
