package com.example.dockerdeployment.mapper;

import com.example.dockerdeployment.dto.UserResponseDto;
import com.example.dockerdeployment.entity.DockerUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;


@Mapper(componentModel = "spring")
public interface UserMapperService {

    UserResponseDto fromEntity(DockerUser user);

}
