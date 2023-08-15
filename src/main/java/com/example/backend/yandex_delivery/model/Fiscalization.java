package com.example.backend.yandex_delivery.model;

import com.example.backend.yandex_delivery.enums.ItemType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Fiscalization {
    // Информация по фискализации (актуально для оплаты при получении)
    private String article; // Артикул товара. Должен быть уникальным для товаров, передаваемых в точке.
    private BigDecimal excise;//Цена Decimal(19, 4)
    private ItemType item_type; // Тип наименования: товар или услуга. По-умолчанию считаем, что product
    private Mark mark; // Признак маркированности товара Допустимое значение quantity для товара с маркировкой - 1
    private String supplier_inn; // ИНН поставщика (10 или 12 цифр)
    private String vat_code_str; /*
    Ставка НДС. vat_none - без НДС; vat0 - нулевая ставка НДС (применяется в редких случаях);
     vat10 - ставка НДС 10%; vat20 - ставка НДС 20%. */
}
