package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.model;

import com.example.backend.yandex_delivery.model.delivery_order.base.DeliveryInterval;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SameDayDelivery {
    private boolean allowed;
    private List<DeliveryInterval> availableIntervals;
}
