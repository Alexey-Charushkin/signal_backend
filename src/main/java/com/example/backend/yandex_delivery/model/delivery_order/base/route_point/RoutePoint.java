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
    // ����� ��������
    @NotNull
    private Address address;
    private BuyOut buyout;
    @NotNull
    private Contact contact;
    private ExternalOrderCost external_order_cost;
    private String external_order_id; // ����� ������ �� ������� �������. ���������� ��� ����� � ����� destination
    private boolean leave_under_door; // �������� ������� � �����
    private boolean meet_outside; // ������� �������� �� ����� � ��������
    private boolean no_door_call; // �� ������� � �����
    private PaymentOnDelivery payment_on_delivery; // ���������� �� ������ ��� ��������� (��������� ��� ������ ��� ���������)
    private String pickup_code; /* ��� ������ ������� �������. ������� ����������� ������ ���� ���, ����� �����������,
     ��� �� ������� ���� �������. ��� ����� ����������, ����� ���� ���������� �� ����� ������ ����� �����������
      ������� ���� ��� �������. ��������� ��� ����� � type = 'source'. ������: ����� 6 ���� | ��� ������ ������ (���) */
    @NotNull
    private int point_id; /* ������������� ������������� �����, ������������ �� ������� ��������.
     ���������� � ���� route_points[].id. ��������� � ������ � ����� source, destination, return. */
    private int skip_confirmation; // ���������� ������������� ����� SMS � ������ ����� �� ���������: false (������������� ���������)
    @NotNull
    private RoutePointType type; /* ��� �����:
    source - ����� �����������, ��� ������ �������� �����
    destination � ����� ����������, ��� ������ �������� �����
    return - ����� �������� ������ (����������� ������������� � �� ��������� ��������� � ������ �����������,
    �� ����� ����� ���������� ������ �����) */
    @NotNull
    private int visit_order; // ������� ��������� ����� (��������� � 1)
}
