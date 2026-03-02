package com.example.dockerdeployment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Entity
@Table(name="user")
public class DockerUser extends BaseModel{
    @NotNull
    private String name;
    @NotNull
    private String email;
    }
