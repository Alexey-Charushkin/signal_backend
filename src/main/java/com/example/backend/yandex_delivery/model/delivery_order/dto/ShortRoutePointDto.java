package com.example.backend.yandex_delivery.model.delivery_order.dto;

import com.example.backend.yandex_delivery.enums.RoutePointType;
import com.example.backend.yandex_delivery.enums.VisitStatus;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced.BuyOut;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced.ExternalOrderCost;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced.PaymentOnDelivery;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Address;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Contact;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.VisitedAt;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShortRoutePointDto {
    // точка маршрута
    @NotNull
    private ShortAddressDto address;
    @NotNull
    private ShortContactDto contact;
    @NotNull
    private int point_id; /* Целочисленный идентификатор точки, генерируемый на стороне Доставки.
     Содержится в поле route_points[].id. Применимо к точкам с типом source, destination, return. */
    @NotNull
    private String type; /* Тип точки:
    source - точка отправления, где курьер забирает товар
    destination – точки назначения, где курьер передает товар
    return - точка возврата товара (добавляется автоматически и по умолчанию совпадает с точкой отправления,
    но также можно определить другую точку) */
    @NotNull
    private int visit_order; // Порядок посещения точки (нумерация с 1)
    @NotNull
    private String visit_status; /* татус посещения данной точки: pending - точка еще не посещена;
     arrived - водитель прибыл на точку; visited - водитель передал/забрал груз на точке; partial_delivery - точка посещена,
      но часть груза не передана; skipped - точка пропущена (в случае возврата, когда клиент не смог принять груз) */
    @NotNull
    private VisitedAt visited_at; // (int64) Ожидаемое время ожидания в точке.

}
