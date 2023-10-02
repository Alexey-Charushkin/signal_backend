package com.example.backend.yandex_delivery.model.delivery_order;

import com.example.backend.yandex_delivery.enums.CancelState;
import com.example.backend.yandex_delivery.enums.DeliveryOrderStatus;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base.Requirements;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.CallbackProperties;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.EmergencyContact;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.same_day_data.SameDayData;
import com.example.backend.yandex_delivery.model.delivery_order.base.DeliveryItem;
import com.example.backend.yandex_delivery.model.delivery_order.base.route_point.RoutePoint;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delivery_orders")
public class DeliveryOrder {
    @Column(name = "id")
    private String id; // Идентификатор заявки, полученный на этапе создания заявки от ip яндекс доставки
    @Id
    @Column(name = "delivery_orders_uuid")
    private UUID uuid;
    @Transient
    private boolean auto_accept; // Автоматическое подтверждение заявки после создания
    @Transient
    private CallbackProperties callback_properties;
    @Transient
    private Requirements client_requirements;
    @Transient
    private String comment;
    @Column(name = "created_ts")
    private LocalDateTime created_ts;
    @Column(name = "updated_ts")
    private LocalDateTime updated_ts;
    @Column(name = "due")
    private LocalDateTime due; // (date-time) Создать заказ к определенному времени (например, заказ на завтра).
    // Без указания данного поля поиск будет осуществлен
    // на ближайшее время. Согласуйте с менеджером использование опции!
    @Transient
    private EmergencyContact emergency_contact; // Информация о контактном лице с номером телефона
    //@Column(name = "delivery_items_id")
    @Transient
    private List<DeliveryItem> items; // Перечисление наименований грузов для отправления
    @Column(name = "revision")
    private int revision;
    @Transient
    private String offer_payload; // Payload, полученный в ручке /api/integration/v2/offers/calculate
    @Transient
    private boolean optional_return; /* Не требуется возврат товаров в случае отмены заказа.
    Возможные значения:
            true (курьер оставляет товар себе)
            false (по умолчанию, требуется вернуть товар) */
    @Transient
    private String referral_source; // Источник заявки (можно передать наименование CMS, из которой создается запрос)
    //@Column(name = "route_points_id")
    @Transient
    private List<RoutePoint> route_points; // Информация по точкам маршрута
    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_order_status")
    private DeliveryOrderStatus status;  // Статус доставки
    @Transient
    private SameDayData same_day_data; // Дополнительная информация для заявок "В течение дня"
    @Transient
    private String shipping_document; // Сопроводительные документы
    @Transient
    private boolean skip_act; // Не показывать акт
    @Transient
    private boolean skip_client_notify; // Не отправлять отправителю/получателю смс-нотификации,
    // когда к нему направится курьер. По умолчанию: false (отправлять нотификацию)
    @Transient
    private boolean skip_door_to_door; /* Отказ от доставки до двери (выключить опцию "От двери до двери").
    Возможные значения:
            true (курьер доставит заказ только на улицу, до подъезда)
            false (по умолчанию, доставка от двери до двери)
            */
    @Transient
    private boolean skip_emergency_notify; // Не отправлять нотификации emergency контакту По умолчанию: false (отправлять нотификации)
    @Column(name = "user_request_revision")
    private String user_request_revision;
    @Column(name = "version")
    private int version;
    @Enumerated(EnumType.STRING)
    @Column(name = "available_cancel_state")
    private CancelState available_cancel_state;


    public CancelState getAvailable_cancel_state() {
        return available_cancel_state;
    }
}
