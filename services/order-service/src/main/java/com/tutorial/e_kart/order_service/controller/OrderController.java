package com.tutorial.e_kart.order_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @GetMapping("/ping")
    public String ping() {
        return "Order service is running";
    }
}
