package com.tutorial.ekart.product_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @GetMapping("/ping")
    public String ping() {
        return "Product service is running";
    }
}
