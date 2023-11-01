package com.example.backend.yandexdelivery.model.deliveryorder.base;

import com.example.backend.yandexdelivery.model.initialcostestimate.advanced.CurrencyRules;
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
