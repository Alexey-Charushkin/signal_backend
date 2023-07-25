package com.example.backend.model.dto;

import com.example.backend.model.Restaurant;
import com.example.backend.model.User;
import com.example.backend.model.enums.PaymentMethodEnum;
import com.example.backend.model.enums.StatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDTO {
    private Long orderId;
    @NotNull(message = "Укажите, пожалуйста, пользователя, который сделал заказ.")
    private User user;
    @NotNull(message = "Укажите, пожалуйста, ресторан, в котором сделан заказ.")
    private Restaurant restaurant;
    @NotNull(message = "Укажите, пожалуйста, статус заказа.")
    private StatusEnum status;
    @NotNull(message = "Укажите, пожалуйста, способ доставки.")
    private PaymentMethodEnum paymentMethod;

}
