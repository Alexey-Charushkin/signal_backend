package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseWithDayDeliveryDto {
    private ExpressDeliveryDto express_delivery;
    private SameDayDeliveryDto same_day_delivery;
}
