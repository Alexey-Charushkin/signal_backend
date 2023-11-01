package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseWithDayDeliveryDto {
    private ExpressDeliveryDto express_delivery;
    private SameDayDeliveryDto same_day_delivery;
}
