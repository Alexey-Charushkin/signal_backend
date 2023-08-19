package com.example.backend.yandex_delivery.model.delivery_order.advanced.fiscalization;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mark {
    // ������� ��������������� ������ ���������� �������� quantity ��� ������ � ����������� - 1
    @NotNull
    @NotBlank
    private String code; // �������� ��������� ������ � ������������ � �������� kind
    @NotNull
    @NotBlank
    private String kind; /* ��� ����������. ��������� ��������:
compiled - ��� ����������� ����� � ���������� GTIN � Serial. ������:
444D00000000003741
gs1_data_matrix_base64 - ��� ������ � ������� GS1 Data Matrix, ���������� ���������� ���������� �������������.
 �������� 200 ��������. ��� ������ ���������� ���������� �������, ����������� ������ � ������ base64.
 */

}
