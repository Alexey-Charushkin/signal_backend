package com.example.backend.yandexdelivery.model.deliveryorder.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
public class Offer {
    private String offer_id;
    private BigDecimal price;
    private BigDecimal price_with_vat;
    private String valid_until;
}
