package com.example.TwoPizza.controllers;

import com.example.TwoPizza.entities.UserEntity;
import com.example.TwoPizza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok(userService.registration(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error during registration happened");
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok(userService.login(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error during login happened");
        }
    }
}
