package com.example.backend.model.mapper;

import com.example.backend.model.Restaurant;
import com.example.backend.model.dto.RestaurantDTO;
import org.mapstruct.Mapper;

@Mapper
public interface RestaurantMapper {

    RestaurantDTO toRestaurantDTO(Restaurant Restaurant);

    Restaurant toRestaurant(RestaurantDTO RestaurantDTO);
}
