package com.example.backend.yandex_delivery.model.delivery_order.base.route_point.base;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String building; // строение
    private String building_name; // Название апартаментов (здания)
    private String city;
    private String comment; // комментарий для курьера
    private double[] coordinates; // Массив из двух вещественных чисел [долгота, широта]. Порядок важен!
    // Указываются округленные значения координат.
    private String country;
    private String description; // Географическая область, уточняющая shortname до глобального соответствия
    private String door_code; // код домофона
    private String door_code_extra; // Дополнительные указания по домофонам
    private String doorbell_name; // Имя на дверном звонке
    private String fullname; /* Полное название с указанием города (Москва, Садовническая набережная, 82с2).
     Важно вводить населенный пункт с указанием номера дома, но без номера квартиры, подъезда, этажа */
    private String porch; // Подъезд (может быть A)
    private String sflat; // квартира
    private String sfloor; // этаж
    private String shortname; // Адрес в пределах города, как показывается на Таксометре (Садовническая набережная, 82с2)
    private String street; // улица
    private String uri; // Карточный uri геообъекта
}
