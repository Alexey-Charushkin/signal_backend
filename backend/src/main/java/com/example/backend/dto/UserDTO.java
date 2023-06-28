package com.example.backend.dto;

import com.example.backend.model.enums.RoleEnum;
import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private Long telegramId;
    private String address;
    private String phoneNumber;
    private RoleEnum role;
}
