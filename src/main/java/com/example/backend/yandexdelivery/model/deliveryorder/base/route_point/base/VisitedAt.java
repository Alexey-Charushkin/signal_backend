package com.example.backend.yandexdelivery.model.deliveryorder.base.route_point.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
public class VisitedAt {
    private LocalDateTime actual; // (date-time)
    private LocalDateTime expected; // (date-time)
    private int expected_waiting_time_sec; // (int64)
}
