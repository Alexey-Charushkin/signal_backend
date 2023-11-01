package com.example.backend.yandexdelivery.model.withinadaydeliveryinterval.dto;

import com.example.backend.yandexdelivery.model.deliveryorder.dto.DeliveryIntervalDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SameDayDeliveryDto {
    private boolean allowed;
    private List<DeliveryIntervalDto> availableIntervals;
}
