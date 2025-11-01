package com.tutorial.ekart.auth_service.controller;

import com.tutorial.ekart.auth_service.dto.AuthRequest;
import com.tutorial.ekart.auth_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final JwtUtil jwtUtil;

    @Value("${userservice.url}")
    private String userServiceUrl;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        // call user-service authenticate endpoint
        String url = userServiceUrl + "/api/users/authenticate";
        try {
            ResponseEntity<Map> resp = restTemplate.postForEntity(url, req, Map.class);
            if (!resp.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.status(401).body("invalid credentials");
            }
            Map body = resp.getBody();
            String userId = (String) body.get("id");
            String token = jwtUtil.generateToken(userId);
            return ResponseEntity.ok(Map.of("accessToken", token));
        } catch (Exception ex) {
            return ResponseEntity.status(401).body("invalid credentials");
        }
    }
}
