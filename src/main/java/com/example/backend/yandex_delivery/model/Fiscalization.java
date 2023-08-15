package com.example.backend.yandex_delivery.model;

import com.example.backend.yandex_delivery.enums.ItemType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Fiscalization {
    // ���������� �� ������������ (��������� ��� ������ ��� ���������)
    private String article; // ������� ������. ������ ���� ���������� ��� �������, ������������ � �����.
    private BigDecimal excise;//���� Decimal(19, 4)
    private ItemType item_type; // ��� ������������: ����� ��� ������. ��-��������� �������, ��� product
    private Mark mark; // ������� ��������������� ������ ���������� �������� quantity ��� ������ � ����������� - 1
    private String supplier_inn; // ��� ���������� (10 ��� 12 ����)
    private String vat_code_str; /*
    ������ ���. vat_none - ��� ���; vat0 - ������� ������ ��� (����������� � ������ �������);
     vat10 - ������ ��� 10%; vat20 - ������ ��� 20%. */
}
