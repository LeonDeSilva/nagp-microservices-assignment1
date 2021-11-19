package com.leondesilva.msassignment1.adminsservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @PostMapping("/admin/orders")
    public ResponseEntity<Object> assignServiceProviderToOrder() {
        return ResponseEntity.ok().build();
    }
}
