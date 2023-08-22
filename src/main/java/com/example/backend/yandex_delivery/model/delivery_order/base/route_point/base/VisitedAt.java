package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VisitedAt {
    private LocalDateTime actual; // (date-time)‘актическое врем€ посещени€ точки. «аполн€етс€ только дл€ посещенных точек
    private LocalDateTime expected; // (date-time) ќжидаемое врем€ посещени€. ћожет быть заполнено (в некоторых случа€х)
    // только дл€ непосещенных точек.
    private int expected_waiting_time_sec; // (int64) ќжидаемое врем€ ожидани€ в точке.
}
