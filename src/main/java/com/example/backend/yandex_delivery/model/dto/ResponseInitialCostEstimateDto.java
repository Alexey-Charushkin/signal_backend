package com.example.backend.yandex_delivery.model.dto;

import com.example.backend.yandex_delivery.model.CurrencyRules;
import com.example.backend.yandex_delivery.model.Requirements;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ResponseInitialCostEstimateDto {

    private CurrencyRules currency_rules;

    private int distance_meters; // ���������� � ������ ��� ��������, ������� ��� �������� �� ������ �������, ������� � ������ ����� � ���������� ���������

    private int eta; // ETA � �������, ��� ������ �� /orders/estimate
    @NotNull
    private BigDecimal price; // ����� � ������� Decimal(18, 4)
    @NotNull
    private Requirements requirements; // ���������� � �������� (����� ����, �����)

    private String zone_id; //

}

  /*  {
  "currency_rules": {
    "code": "RUB",
    "sign": "?",
    "template": "$VALUE$ $SIGN$$CURRENCY$",
    "text": "���."
  },
  "distance_meters": 10,
  "eta": 10,
  "price": "12.50",
  "requirements": {
    "cargo_loaders": 1,
    "cargo_options": "thermobag",
    "cargo_type": "lcv_m",
    "pro_courier": false,
    "same_day_data": {
      "delivery_interval": {
        "from": "2020-01-01T00:00:00+00:00",
        "to": "2020-01-02T00:00:00+00:00"
      }
    },
    "taxi_class": "cargo"
  },
  "zone_id": "moscow"
}

   */

/*    {"currency_rules": {
      "code":"RUB",
      "sign":"?",
      "template":"$VALUE$ $SIGN$$CURRENCY$",
      "text":"���."
      },
      "distance_meters":10,
      "eta":0,
      "price":15.2,
      "requirements": {
         "assign_robot":false,
         "cargo_loaders":0,
         "cargo_options":["AUTO_COURIER"],
         "cargo_type":"VAN",
         "pro_courier":true,
         "taxi_class":"EXPRESS"
         },
       "zone_id":"moscow"

       } */