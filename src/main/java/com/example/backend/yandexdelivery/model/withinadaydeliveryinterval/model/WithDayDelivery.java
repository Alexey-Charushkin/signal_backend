package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WithDayDelivery {
    private ExpressDelivery express_delivery;
    private SameDayDelivery same_day_delivery;
}
