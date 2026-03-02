package com.example.dockerdeployment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private int id;
    private String name;
    private String email;
}
