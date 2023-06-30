package com.example.backend.mapper;

import com.example.backend.dto.DishDTO;
import com.example.backend.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DishMapper {
    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);
    DishDTO toDto(Dish dish);
    Dish toEntity(DishDTO dishDTO);
}
