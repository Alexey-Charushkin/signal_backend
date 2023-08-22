package com.example.backend.yandex_delivery.model.delivery_order.dto;

import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrderResponse;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.fiscalization.Fiscalization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShortCargoDto {
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
    @NotNull(groups = {DeliveryOrderResponse.class})
    private int pickup_point; /* Идентификатор точки, откуда нужно забрать товар (отличается от идентификатора в заявке).
    Может быть любым числом. Должен соответствовать значению route_points[].point_id у точки забора */
    @NotNull(groups = {DeliveryOrderResponse.class})
    private int quantity; // minimum:1 Количество указанного товара
    @NotNull(groups = {DeliveryOrderResponse.class})
    private String title; // Наименование единицы товара
}
