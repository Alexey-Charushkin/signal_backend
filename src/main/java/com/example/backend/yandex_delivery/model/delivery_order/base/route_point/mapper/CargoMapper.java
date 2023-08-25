package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.mapper;

import com.example.backend.yandex_delivery.model.delivery_order.base.Cargo;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Address;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortAddressDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortCargoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CargoMapper {

    Cargo toCargo(ShortCargoDto shortCargoDto);
    ShortCargoDto toShortShortCargoDto(Cargo cargo);
}
