package com.tutorial.e_kart.user_service.service;

import com.tutorial.e_kart.user_service.model.User;
import com.tutorial.e_kart.user_service.model.RegisterRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User register(RegisterRequest req) {
        User u = new User();
        u.setUsername(req.getUsername());
        u.setEmail(req.getEmail());
        u.setPasswordHash(passwordEncoder.encode(req.getPassword()));
        users.put(u.getId(), u);
        return u;
    }

    public User authenticate(String username, String password) {
        return users.values().stream()
                .filter(u -> u.getUsername().equals(username))
                .filter(u -> passwordEncoder.matches(password, u.getPasswordHash()))
                .findFirst().orElse(null);
    }
}
