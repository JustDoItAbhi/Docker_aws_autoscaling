package com.example.dockerdeployment.repository;

import com.example.dockerdeployment.entity.DockerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<DockerUser,Integer> {
    Optional<DockerUser> findByName(String name);
}
