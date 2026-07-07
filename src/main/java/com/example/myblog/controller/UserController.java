package com.example.myblog.controller;

import com.example.myblog.dto.LoginRequest;
import com.example.myblog.dto.RegisterRequest;
import com.example.myblog.dto.UserResponse;
import com.example.myblog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody RegisterRequest request) {
        return userService.register(request);
    }

//    @PostMapping("/login")
//    public UserResponse login(@Valid @RequestBody LoginRequest request) {
//        return userService.login(request);
//    }
}
