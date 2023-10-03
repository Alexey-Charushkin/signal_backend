package com.example.backend.yandex_delivery.model.delivery_order.base;

import com.example.backend.yandex_delivery.model.delivery_order.advanced.fiscalization.Fiscalization;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.item.Size;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class DeliveryItem {
    private String cost_currency;
    private BigDecimal cost_value;
    private long droppof_point;
    private long extra_id;
    private Fiscalization fiscalization;
    private long pickup_point;
    private long quantity;
    private Size size;
    private String title;
    private float weight;
}
