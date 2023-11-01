package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.model;

import com.example.backend.yandexdelivery.model.deliveryorder.base.DeliveryInterval;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SameDayDelivery {
    private boolean allowed;
    private List<DeliveryInterval> availableIntervals;
}
