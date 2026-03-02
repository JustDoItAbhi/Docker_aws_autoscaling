package com.example.dockerdeployment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private int id;
    private String name;
    private String email;
}
