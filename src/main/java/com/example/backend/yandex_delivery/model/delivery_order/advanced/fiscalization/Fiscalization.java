package com.example.backend.yandex_delivery.model.delivery_order.advanced.fiscalization;

import com.example.backend.yandex_delivery.enums.ItemType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Fiscalization {

    private String article;
    private BigDecimal excise;
    private ItemType item_type;
    private Mark mark;
    private String supplier_inn;
    private String vat_code_str;
}
