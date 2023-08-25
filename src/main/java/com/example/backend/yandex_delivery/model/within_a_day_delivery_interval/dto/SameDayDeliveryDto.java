package com.example.backend.yandex_delivery.model.within_a_day_delivery_interval.dto;

import com.example.backend.yandex_delivery.model.delivery_order.dto.DeliveryIntervalDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SameDayDeliveryDto {
    private boolean allowed;
    private List<DeliveryIntervalDto> availableIntervals;
}
