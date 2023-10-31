package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ExternalOrderCost {
    private String currency;
    private String currency_sign;
    private BigDecimal value;
}
