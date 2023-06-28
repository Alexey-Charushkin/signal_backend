package com.example.backend.dto;

import lombok.Data;

@Data
public class RestaurantDTO {
    private Long restaurantId;
    private String name;
    private String address;
    private String phone;
    private String email;
}
