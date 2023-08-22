package com.example.backend.yandex_delivery.model.delivery_order.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VisitedAtDto {
    private LocalDateTime actual; // (date-time)
    private LocalDateTime expected; // (date-time)
    private int expected_waiting_time_sec; // (int64)
}
