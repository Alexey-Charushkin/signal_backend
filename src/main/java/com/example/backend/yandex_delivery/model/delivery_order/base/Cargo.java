package com.example.backend.yandex_delivery.model.delivery_order.base;

import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrderResponse;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.fiscalization.Fiscalization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Data
@Builder
public class Cargo {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String cost_currency; // ������ ���� �� ����� � ������� ISO 4217 (��� ���������� ��������/�����������
    // �/��� ������ ��� ���������). ������: RUB
    @NotNull
    private BigDecimal cost_value; //���� �� ����� � ������ cost_currency. ��� ����������� ��������� ��������� ����������� ���� �����
    @NotNull
    private int droppof_point; // ������������� �����, ���� ����� ��������� ����� (���������� �� �������������� � ������).
    // ����� ���� ����� ������. ������ ��������������� �������� route_points[].point_id � ����� ����������
    private int extra_id; // ������� ���������� ������������� item'� (����� ������ � ������ ������, ��� ������� ��������� external_order_id)
    private Fiscalization fiscalization;
    @NotNull(groups = {DeliveryOrderResponse.class})
    private int pickup_point; /* ������������� �����, ������ ����� ������� ����� (���������� �� �������������� � ������).
    ����� ���� ����� ������. ������ ��������������� �������� route_points[].point_id � ����� ������ */
    @NotNull(groups = {DeliveryOrderResponse.class})
    private int quantity; // minimum:1 ���������� ���������� ������
    private Size size;
    @NotNull(groups = {DeliveryOrderResponse.class})
    private String title; // ������������ ������� ������
    private int weight; /* ��� ������� ������ � ��. � ���� ������� ���������� ���������� ��������.
���� ��� �� ��� �������, ����� ��������� ����������� �� ����������� ���������� �������� ��� ������.
���� ����������� �������������� ����������� �������� ����������, ������ ������ ���������� �� ���������� ������ ������ �� �����. � ���� ������ ����� �������� ��������� ������.
������ (courier): �� 10 �� �������� (express): �� 20 �� �������� (cargo):
��������� �����: �� 300 ��
������� �����: �� 700 ��
������� �����: �� 1400 �� */
}
