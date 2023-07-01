package com.example.backend.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DishDTO {
    private Long dishId;
    @NotBlank(message = "Требуется описание")
    private String description;

    @NotNull(message = "Установите цену")
    @DecimalMin(value = "0.0", inclusive = false, message = "Цена должна быть больше 0")
    private BigDecimal price;

    @NotBlank(message = "Укажите категорию")
    private String category;

    @NotNull(message = "Установите время приготовления")
    @Min(value = 1, message = "Минимальное время приготовления 1 минута")
    private Integer preparationTime;


}
