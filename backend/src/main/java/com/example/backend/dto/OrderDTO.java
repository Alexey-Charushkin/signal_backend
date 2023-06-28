package com.example.backend.dto;

import com.example.backend.model.Restaurant;
import com.example.backend.model.User;
import com.example.backend.model.enums.PaymentMethodEnum;
import com.example.backend.model.enums.StatusEnum;
import lombok.Data;

@Data
public class OrderDTO {
    private Long orderId;
    private User user;
    private Restaurant restaurant;
    private StatusEnum status;
    private PaymentMethodEnum paymentMethod;

}
