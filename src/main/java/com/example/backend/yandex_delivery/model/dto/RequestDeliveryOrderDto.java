package com.example.backend.yandex_delivery.model.dto;

import com.example.backend.yandex_delivery.model.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class RequestDeliveryOrderDto {
    private boolean auto_accept; // Автоматическое подтверждение заявки после создания
    private CallbackProperties callback_properties;
    private Requirements client_requirements;
    private String comment;
    private LocalDateTime due; // (date-time) Создать заказ к определенному времени (например, заказ на завтра).
    // Без указания данного поля поиск будет осуществлен
    // на ближайшее время. Согласуйте с менеджером использование опции!
    private EmergencyContact emergency_contact; // Информация о контактном лице с номером телефона
    @NotNull
    private List<Cargo> items; // Перечисление наименований грузов для отправления
    private String offer_payload; // Payload, полученный в ручке /api/integration/v2/offers/calculate
    private boolean optional_return; /* Не требуется возврат товаров в случае отмены заказа.
    Возможные значения:
            true (курьер оставляет товар себе)
            false (по умолчанию, требуется вернуть товар) */
    private String referral_source; // Источник заявки (можно передать наименование CMS, из которой создается запрос)
    @NotNull
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
/* {
        "auto_accept": boolean,
        "callback_properties": {
        "callback_url": string
        },
        "client_requirements": {
        "assign_robot": boolean,
        "cargo_loaders": integer,
        "cargo_options": [
        string
        ],
        "cargo_type": string,
        "pro_courier": boolean,
        "taxi_class": string
        },
        "comment": string,
        "due": string,
        "emergency_contact": {
        "name": string,
        "phone": string,
        "phone_additional_code": string
        },
        "items": [
        {
        "cost_currency": string,
        "cost_value": string,
        "droppof_point": integer,
        "extra_id": string,
        "fiscalization": {
        "article": string,
        "excise": string,
        "item_type": string,
        "mark": {
        "code": string,
        "kind": string
        },
        "supplier_inn": string,
        "vat_code_str": string
        },
        "pickup_point": integer,
        "quantity": integer,
        "size": {
        "height": number,
        "length": number,
        "width": number
        },
        "title": string,
        "weight": number
        }
        ],
        "offer_payload": string,
        "optional_return": boolean,
        "referral_source": string,
        "route_points": [
        {
        "address": {
        "building": string,
        "building_name": string,
        "city": string,
        "comment": string,
        "coordinates": [
        number
        ],
        "country": string,
        "description": string,
        "door_code": string,
        "door_code_extra": string,
        "doorbell_name": string,
        "flat": integer,
        "floor": integer,
        "fullname": string,
        "porch": string,
        "sflat": string,
        "sfloor": string,
        "shortname": string,
        "street": string,
        "uri": string
        },
        "buyout": {
        "payment_method": string
        },
        "contact": {
        "email": string,
        "name": string,
        "phone": string,
        "phone_additional_code": string
        },
        "external_order_cost": {
        "currency": string,
        "currency_sign": string,
        "value": string
        },
        "external_order_id": string,
        "leave_under_door": boolean,
        "meet_outside": boolean,
        "no_door_call": boolean,
        "payment_on_delivery": {
        "customer": {
        "email": string,
        "inn": string,
        "phone": string
        },
        "payment_method": string
        },
        "pickup_code": string,
        "point_id": integer,
        "skip_confirmation": boolean,
        "type": string,
        "visit_order": integer
        }
        ],
        "same_day_data": {
        "delivery_interval": {
        "from": string,
        "to": string
        }
        },
        "shipping_document": string,
        "skip_act": boolean,
        "skip_client_notify": boolean,
        "skip_door_to_door": boolean,
        "skip_emergency_notify": boolean
        }
        */
