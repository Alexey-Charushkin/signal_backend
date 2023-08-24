package com.example.backend.yandex_delivery.model.express_delivery_interval;

import com.example.backend.yandex_delivery.model.delivery_order.advanced.same_day_data.DeliveryInterval;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SameDayDelivery {
    private boolean allowed;
    private List<DeliveryInterval> availableIntervals;
}
