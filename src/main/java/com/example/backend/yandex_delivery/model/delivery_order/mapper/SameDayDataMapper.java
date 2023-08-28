package com.example.backend.yandex_delivery.model.delivery_order.mapper;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.same_day_data.SameDayData;
import com.example.backend.yandex_delivery.model.delivery_order.dto.SameDayDataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SameDayDataMapper {

    SameDayData toSameDayData(SameDayDataDto sameDayDataDto);

    SameDayDataDto toSameDayDataDto(SameDayData sameDayData);
}
