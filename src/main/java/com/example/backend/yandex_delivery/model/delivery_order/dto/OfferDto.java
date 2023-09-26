package com.example.backend.yandex_delivery.model.delivery_order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferDto {
    private String offer_id;
    private BigDecimal price;
    private BigDecimal price_with_vat;
    private String valid_until;
}
