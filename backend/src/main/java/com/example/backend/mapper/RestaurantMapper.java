package com.example.backend.mapper;

import com.example.backend.dto.RestaurantDTO;
import com.example.backend.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDTO toRestaurantDTO(Restaurant Restaurant);

    Restaurant toRestaurant(RestaurantDTO RestaurantDTO);
}
