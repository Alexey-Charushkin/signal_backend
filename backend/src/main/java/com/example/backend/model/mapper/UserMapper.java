package com.example.backend.model.mapper;

import com.example.backend.model.User;
import com.example.backend.model.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDTO toUserDTO(User User);

    User toUser(UserDTO UserDTO);
}
