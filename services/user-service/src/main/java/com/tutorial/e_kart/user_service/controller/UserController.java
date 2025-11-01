package com.tutorial.e_kart.user_service.controller;

import com.tutorial.e_kart.user_service.model.AuthRequest;
import com.tutorial.e_kart.user_service.model.RegisterRequest;
import com.tutorial.e_kart.user_service.model.User;
import com.tutorial.e_kart.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest req) {
        User u = userService.register(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest req) {
        User u = userService.authenticate(req.getUsername(), req.getPassword());
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid credentials");
        }
        return ResponseEntity.ok(u);
    }
}
