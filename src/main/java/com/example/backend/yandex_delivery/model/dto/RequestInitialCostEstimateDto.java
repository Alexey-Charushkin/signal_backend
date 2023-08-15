package com.example.backend.yandex_delivery.model.dto;

import com.example.backend.yandex_delivery.model.Item;
import com.example.backend.yandex_delivery.model.Requirements;
import com.example.backend.yandex_delivery.model.RoutePoint;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RequestInitialCostEstimateDto {
    // Первичная оценка стоимости без создания заявки
    @NotNull(message = "Введите количество коробок")
    private List<Item> items;
    private Requirements client_requirements;
    @NotNull(message = "Введите адрес доставки")
    private List<RoutePoint> route_points;
    private boolean skip_door_to_door; /* Отказ от доставки до двери (выключить опцию "От двери до двери").
    Возможные значения:
            true (курьер доставит заказ только на улицу, до подъезда)
            false (по умолчанию, доставка от двери до двери)
            */
}
/*
{
  "items": [
    {
      "quantity": 1,
      "size": {
        "height": 0.1,
        "length": 0.1,
        "width": 0.1
      },
      "weight": 2
    }
  ],
  "client_requirements": {
    "assign_robot" : false,
    "cargo_loaders": 0,
    "cargo_options": ["thermobag", "auto_courier"],
    "cargo_type": "lcv_m",
    "pro_courier": false,
    "taxi_class": "express"
  },
  "route_points": [
    {"coordinates": [37.588074, 55.733924]},
    {"coordinates": [37.584822, 55.751339]}],
  "skip_door_to_door": false
}

 */
/*
{
    "items": [
     {
      "quantity":1,
      "size": {
          "height":0.1,
          "length":0.1
          ,"width":0.2
       },
       "weight":1.4
       }
    ],
    "client_requirements": {
       "assign_robot":false,
       "cargo_loaders":0,
       "cargo_options":["AUTO_COURIER"],
       "cargo_type":"VAN",
       "pro_courier":true,
       "taxi_class":"EXPRESS"
       },
       "route_points" : [
       {"coordinates":[25.12,64.11],
       "fullname":"ул. Васи Пупкина д.2"}],
       "skip_door_to_door":false

       } */