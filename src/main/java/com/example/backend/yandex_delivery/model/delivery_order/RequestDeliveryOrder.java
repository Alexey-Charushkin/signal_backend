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
    // ������ ������ �� �������� ������ �� ��������
    private boolean auto_accept; // �������������� ������������� ������ ����� ��������
    private CallbackProperties callback_properties;
    private Requirements client_requirements;
    private String comment;
    private LocalDateTime due; // (date-time) ������� ����� � ������������� ������� (��������, ����� �� ������).
    // ��� �������� ������� ���� ����� ����� �����������
    // �� ��������� �����. ���������� � ���������� ������������� �����!
    private EmergencyContact emergency_contact; // ���������� � ���������� ���� � ������� ��������
    private List<Cargo> items; // ������������ ������������ ������ ��� �����������
    private String offer_payload; // Payload, ���������� � ����� /api/integration/v2/offers/calculate
    private boolean optional_return; /* �� ��������� ������� ������� � ������ ������ ������.
    ��������� ��������:
            true (������ ��������� ����� ����)
            false (�� ���������, ��������� ������� �����) */
    private String referral_source; // �������� ������ (����� �������� ������������ CMS, �� ������� ��������� ������)
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
