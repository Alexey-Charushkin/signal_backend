package com.example.backend.yandex_delivery.model.delivery_order.base.route_point;

import com.example.backend.yandex_delivery.enums.RoutePointType;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced.BuyOut;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced.ExternalOrderCost;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.advanced.PaymentOnDelivery;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Address;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Contact;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoutePoint {
    // точка маршрута
    @NotNull
    private Address address;
    private BuyOut buyout;
    @NotNull
    private Contact contact;
    private ExternalOrderCost external_order_cost;
    private String external_order_id; // Номер заказа из системы клиента. Передается для точки с типом destination
    private boolean leave_under_door; // Оставить посылку у двери
    private boolean meet_outside; // Курьера встретят на улице у подъезда
    private boolean no_door_call; // Не звонить в дверь
    private PaymentOnDelivery payment_on_delivery; // Информация по оплате при получении (актуально для оплаты при получении)
    private String pickup_code; /* Код выдачи посылки курьеру. Курьеру потребуется ввести этот код, чтобы подтвердить,
     что он забрать вашу посылку. Для этого необходимо, чтобы ваши сотрудники на точке выдачи имели возможность
      назвать этот код курьеру. Актуально для точке с type = 'source'. Формат: ровно 6 цифр | Код выдачи товара (ПВЗ) */
    @NotNull
    private int point_id; /* Целочисленный идентификатор точки, генерируемый на стороне Доставки.
     Содержится в поле route_points[].id. Применимо к точкам с типом source, destination, return. */
    private int skip_confirmation; // Пропускать подтверждение через SMS в данной точке По умолчанию: false (подтверждение требуется)
    @NotNull
    private RoutePointType type; /* Тип точки:
    source - точка отправления, где курьер забирает товар
    destination – точки назначения, где курьер передает товар
    return - точка возврата товара (добавляется автоматически и по умолчанию совпадает с точкой отправления,
    но также можно определить другую точку) */
    @NotNull
    private int visit_order; // Порядок посещения точки (нумерация с 1)
}
