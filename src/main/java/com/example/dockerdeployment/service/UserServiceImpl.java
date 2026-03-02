package com.example.dockerdeployment.service;

import com.example.dockerdeployment.dto.UserRequestDto;
import com.example.dockerdeployment.dto.UserResponseDto;
import com.example.dockerdeployment.entity.DockerUser;
import com.example.dockerdeployment.mapper.UserMapperService;
import com.example.dockerdeployment.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final UserMapperService mapperService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapperService mapperService) {
        this.userRepository = userRepository;
        this.mapperService = mapperService;
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto dto) {
        Optional<DockerUser>exsitingUser=userRepository.findByName(dto.getName());
        if(exsitingUser.isPresent()){
            return mapperService.fromEntity(exsitingUser.get());
        }
        DockerUser user=new DockerUser();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        userRepository.save(user);
        return mapperService.fromEntity(user);
    }

    @Override
    public UserResponseDto getUser(int id) {
        DockerUser user=userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException(" USER NOT FOUND "+id));

        return mapperService.fromEntity(user);
    }

    @Override
    public List<UserResponseDto> allUsers() {
        List<DockerUser>users=userRepository.findAll();
        List<UserResponseDto>responseDtos=new ArrayList<>();
        for(DockerUser dockerUser:users){
            responseDtos.add(mapperService.fromEntity(dockerUser));
        }

        return responseDtos;
    }
}
