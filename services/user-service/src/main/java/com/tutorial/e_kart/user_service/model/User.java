package com.tutorial.e_kart.user_service.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private final String id;
    private String username;
    private String passwordHash;
    private String email;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

}
