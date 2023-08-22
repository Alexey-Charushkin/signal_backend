package com.example.backend.yandex_delivery.model.delivery_order.dto;

import com.example.backend.yandex_delivery.model.delivery_order.DeliveryOrderResponse;
import com.example.backend.yandex_delivery.model.delivery_order.advanced.fiscalization.Fiscalization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShortCargoDto {
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
    @NotNull(groups = {DeliveryOrderResponse.class})
    private int pickup_point; /* ������������� �����, ������ ����� ������� ����� (���������� �� �������������� � ������).
    ����� ���� ����� ������. ������ ��������������� �������� route_points[].point_id � ����� ������ */
    @NotNull(groups = {DeliveryOrderResponse.class})
    private int quantity; // minimum:1 ���������� ���������� ������
    @NotNull(groups = {DeliveryOrderResponse.class})
    private String title; // ������������ ������� ������
}
