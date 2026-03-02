package com.example.dockerdeployment.service;

import com.example.dockerdeployment.dto.UserRequestDto;
import com.example.dockerdeployment.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto saveUser(UserRequestDto dto);
    UserResponseDto getUser(int id);
    List<UserResponseDto> allUsers();
}
