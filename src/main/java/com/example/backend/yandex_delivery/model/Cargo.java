package com.example.backend.yandex_delivery.model;

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


}
