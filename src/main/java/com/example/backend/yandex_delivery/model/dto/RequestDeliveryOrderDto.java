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
    private boolean auto_accept; // �������������� ������������� ������ ����� ��������
    private CallbackProperties callback_properties;
    private Requirements client_requirements;
    private String comment;
    private LocalDateTime due; // (date-time) ������� ����� � ������������� ������� (��������, ����� �� ������).
    // ��� �������� ������� ���� ����� ����� �����������
    // �� ��������� �����. ���������� � ���������� ������������� �����!
    private EmergencyContact emergency_contact; // ���������� � ���������� ���� � ������� ��������
    @NotNull
    private List<Cargo> items; // ������������ ������������ ������ ��� �����������
    private String offer_payload; // Payload, ���������� � ����� /api/integration/v2/offers/calculate
    private boolean optional_return; /* �� ��������� ������� ������� � ������ ������ ������.
    ��������� ��������:
            true (������ ��������� ����� ����)
            false (�� ���������, ��������� ������� �����) */
    private String referral_source; // �������� ������ (����� �������� ������������ CMS, �� ������� ��������� ������)
    @NotNull
    private List<RoutePoint> route_points; // ���������� �� ������ ��������
    private SameDayData same_day_data; // �������������� ���������� ��� ������ "� ������� ���"
    private String shipping_document; // ���������������� ���������
    private boolean skip_act; // �� ���������� ���
    private boolean skip_client_notify; // �� ���������� �����������/���������� ���-�����������,
    // ����� � ���� ���������� ������. �� ���������: false (���������� �����������)
    private boolean skip_door_to_door; /* ����� �� �������� �� ����� (��������� ����� "�� ����� �� �����").
    ��������� ��������:
            true (������ �������� ����� ������ �� �����, �� ��������)
            false (�� ���������, �������� �� ����� �� �����)
            */
    private boolean skip_emergency_notify; // �� ���������� ����������� emergency �������� �� ���������: false (���������� �����������)




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
