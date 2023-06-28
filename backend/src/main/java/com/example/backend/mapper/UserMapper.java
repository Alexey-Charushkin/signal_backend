package com.example.backend.mapper;

import com.example.backend.dto.UserDTO;
import com.example.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(User User);

    User toUser(UserDTO UserDTO);
}
