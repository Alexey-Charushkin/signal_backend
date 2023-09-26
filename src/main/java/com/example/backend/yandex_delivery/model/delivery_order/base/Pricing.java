package com.example.backend.yandex_delivery.model.delivery_order.base;

import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.CurrencyRules;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class Pricing {
    private String currency;
    private CurrencyRules currency_rules;
    private String final_price;
    private String final_pricing_calc_id;
    private Offer offer;
}
