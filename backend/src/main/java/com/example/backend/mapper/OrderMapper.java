package com.example.backend.mapper;

import com.example.backend.dto.OrderDTO;
import com.example.backend.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toOrderDTO(Order order);

    Order toOrder(OrderDTO orderDTO);
}
