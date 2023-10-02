package com.example.backend.yandex_delivery.model.delivery_order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.advanced.item.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortDeliveryItemDto {
    @NotNull
    @NotBlank
    private String cost_currency; /* Валюта цены за штуку в формате ISO 4217 (для объявления ценности/страхования
    и/или оплаты при получении). Пример: RUB */
    @NotNull
    private String cost_value; /* Цена за штуку в валюте cost_currency.
     Для страхования стоимости передайте фактическую цену груза */
    @NotNull
    private long droppof_point; /* Идентификатор точки, куда нужно доставить товар (отличается от идентификатора в заявке).
    Может быть любым числом. Должен соответствовать значению route_points[].point_id у точки назначения */
    @NotNull
    private long pickup_point; /* Идентификатор точки, откуда нужно забрать товар (отличается от идентификатора в заявке).
    Может быть любым числом. Должен соответствовать значению route_points[].point_id у точки забора */
    @NotNull
    @Min(1)
    private int quantity; // Количество указанного товара минимум 1
    @NotNull
    private String title; // Наименование единицы товара "Пицца Гавайская"
    @NotNull
    private Size size;
    @NotNull
    private  float weight;
}
