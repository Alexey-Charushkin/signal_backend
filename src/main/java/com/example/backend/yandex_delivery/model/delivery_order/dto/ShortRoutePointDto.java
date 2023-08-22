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
    // ����� ��������
    @NotNull
    private ShortAddressDto address;
    @NotNull
    private ShortContactDto contact;
    @NotNull
    private int point_id; /* ������������� ������������� �����, ������������ �� ������� ��������.
     ���������� � ���� route_points[].id. ��������� � ������ � ����� source, destination, return. */
    @NotNull
    private String type; /* ��� �����:
    source - ����� �����������, ��� ������ �������� �����
    destination � ����� ����������, ��� ������ �������� �����
    return - ����� �������� ������ (����������� ������������� � �� ��������� ��������� � ������ �����������,
    �� ����� ����� ���������� ������ �����) */
    @NotNull
    private int visit_order; // ������� ��������� ����� (��������� � 1)
    @NotNull
    private String visit_status; /* ����� ��������� ������ �����: pending - ����� ��� �� ��������;
     arrived - �������� ������ �� �����; visited - �������� �������/������ ���� �� �����; partial_delivery - ����� ��������,
      �� ����� ����� �� ��������; skipped - ����� ��������� (� ������ ��������, ����� ������ �� ���� ������� ����) */
    @NotNull
    private VisitedAt visited_at; // (int64) ��������� ����� �������� � �����.

}
