package com.example.backend.yandex_delivery.model.delivery_order.base;

import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrderResponse;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.fiscalization.Fiscalization;
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
    private Fiscalization fiscalization;
    @NotNull(groups = {DeliveryOrderResponse.class})
    private int pickup_point; /* Идентификатор точки, откуда нужно забрать товар (отличается от идентификатора в заявке).
    Может быть любым числом. Должен соответствовать значению route_points[].point_id у точки забора */
    @NotNull(groups = {DeliveryOrderResponse.class})
    private int quantity; // minimum:1 Количество указанного товара
    private Size size;
    @NotNull(groups = {DeliveryOrderResponse.class})
    private String title; // Наименование единицы товара
    private int weight; /* Вес единицы товара в кг. В поле следует передавать актуальные значения.
Если вес не был передан, заказ считается оформленным на максимально допустимые габариты для тарифа.
Если фактические характеристики отправления превысят допустимые, курьер вправе отказаться от выполнения такого заказа на месте. В этом случае будет удержана стоимость подачи.
Курьер (courier): до 10 кг Экспресс (express): до 20 кг Грузовой (cargo):
Маленький кузов: до 300 кг
Средний кузов: до 700 кг
Большой кузов: до 1400 кг */
}
