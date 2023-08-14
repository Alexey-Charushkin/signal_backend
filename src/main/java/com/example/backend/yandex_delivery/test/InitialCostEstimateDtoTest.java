package com.example.backend.yandex_delivery.test;

import com.example.backend.yandex_delivery.model.DeliveryInterval;
import com.example.backend.yandex_delivery.model.Item;
import com.example.backend.yandex_delivery.model.Size;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.deser.*;

import java.time.LocalDateTime;

public class InitialCostEstimateDtoTest {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Size size = Size.builder()
                .height(0.1F)
                .length(0.1F)
                .width(0.2F)
                .build();

        DeliveryInterval deliveryInterval = DeliveryInterval.builder()
                .from(LocalDateTime.now())
                .to(LocalDateTime.now().plusHours(1L))
                .build();

        Item item = Item.builder()
                .quantity(1)
                .size(size)
                .weight(1.4F)
                .build();

     //   System.out.println(objectMapper.writeValueAsString(size));
        System.out.println(objectMapper.writeValueAsString(deliveryInterval));
       System.out.println(objectMapper.writeValueAsString(item));
    }
}
