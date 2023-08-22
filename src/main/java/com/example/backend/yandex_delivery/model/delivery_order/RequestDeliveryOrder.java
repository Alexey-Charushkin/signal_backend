package com.example.backend.yandex_delivery.model.delivery_order;

import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Requirements;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.CallbackProperties;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.EmergencyContact;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.same_day_data.SameDayData;
import com.example.backend.yandex_delivery.model.delivery_order.base.Cargo;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class RequestDeliveryOrder {
    // полный запрос на создание заявки на доставку
    private boolean auto_accept; // Автоматическое подтверждение заявки после создания
    private CallbackProperties callback_properties;
    private Requirements client_requirements;
    private String comment;
    private LocalDateTime due; // (date-time) Создать заказ к определенному времени (например, заказ на завтра).
    // Без указания данного поля поиск будет осуществлен
    // на ближайшее время. Согласуйте с менеджером использование опции!
    private EmergencyContact emergency_contact; // Информация о контактном лице с номером телефона
    private List<Cargo> items; // Перечисление наименований грузов для отправления
    private String offer_payload; // Payload, полученный в ручке /api/integration/v2/offers/calculate
    private boolean optional_return; /* Не требуется возврат товаров в случае отмены заказа.
    Возможные значения:
            true (курьер оставляет товар себе)
            false (по умолчанию, требуется вернуть товар) */
    private String referral_source; // Источник заявки (можно передать наименование CMS, из которой создается запрос)
    private List<RoutePoint> route_points; // Информация по точкам маршрута
    private SameDayData same_day_data; // Дополнительная информация для заявок "В течение дня"
    private String shipping_document; // Сопроводительные документы
    private boolean skip_act; // Не показывать акт
    private boolean skip_client_notify; // Не отправлять отправителю/получателю смс-нотификации,
    // когда к нему направится курьер. По умолчанию: false (отправлять нотификацию)
    private boolean skip_door_to_door; /* Отказ от доставки до двери (выключить опцию "От двери до двери").
    Возможные значения:
            true (курьер доставит заказ только на улицу, до подъезда)
            false (по умолчанию, доставка от двери до двери)
            */
    private boolean skip_emergency_notify; // Не отправлять нотификации emergency контакту По умолчанию: false (отправлять нотификации)
}
