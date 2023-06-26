package com.example.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DishDTO {
    private Long dishId;
    private String description;
    private BigDecimal price;
    private String category;
    private int preparationTime;


}
