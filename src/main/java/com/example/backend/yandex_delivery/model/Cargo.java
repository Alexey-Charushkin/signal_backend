package com.example.backend.yandex_delivery.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Data
@Builder
public class Cargo {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String cost_currency; // Валюта цены за штуку в формате ISO 4217 (для объявления ценности/страхования
    // и/или оплаты при получении). Пример: RUB
    @NotNull
    private BigDecimal cost_value; //Цена за штуку в валюте cost_currency. Для страхования стоимости передайте фактическую цену груза
    @NotNull
    private int droppof_point; // Идентификатор точки, куда нужно доставить товар (отличается от идентификатора в заявке).
    // Может быть любым числом. Должен соответствовать значению route_points[].point_id у точки назначения
    private int extra_id; // Краткий уникальный идентификатор item'а (номер заказа в рамках заявки, как правило идентичен external_order_id)


}
