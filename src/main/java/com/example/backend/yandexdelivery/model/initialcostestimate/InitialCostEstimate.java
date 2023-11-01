package com.example.backend.yandexdelivery.model.initialcostestimate;

import com.example.backend.yandexdelivery.model.initialcostestimate.advanced.CurrencyRules;
import com.example.backend.yandexdelivery.model.initialcostestimate.advanced.item.Item;
import com.example.backend.yandexdelivery.model.initialcostestimate.base.InitialCostRoutePoint;
import com.example.backend.yandexdelivery.model.deliveryorder.base.route_point.base.Requirements;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class InitialCostEstimate {
    // Первичная оценка стоимости без создания заявки
    private List<Item> items;
    private Requirements client_requirements;
    private List<InitialCostRoutePoint> route_points;
    private boolean skip_door_to_door; /* Отказ от доставки до двери (выключить опцию "От двери до двери").
    Возможные значения:
            true (курьер доставит заказ только на улицу, до подъезда)
            false (по умолчанию, доставка от двери до двери)
            */
    private CurrencyRules currency_rules;
    private int distance_meters;
    private int eta;
    private BigDecimal price;
    private Requirements requirements;
    private String zone_id;
}
