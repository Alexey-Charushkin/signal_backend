package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WithDayDelivery {
    private ExpressDelivery express_delivery;
    private SameDayDelivery same_day_delivery;

}
