package com.example.backend.model.mapper;

import com.example.backend.model.Order;
import com.example.backend.model.dto.OrderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toOrderDTO(Order order);

    Order toOrder(OrderDTO orderDTO);
}
