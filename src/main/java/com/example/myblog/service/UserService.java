package com.example.myblog.service;

import com.example.myblog.dto.BlogRequest;
import com.example.myblog.dto.LoginRequest;
import com.example.myblog.dto.RegisterRequest;
import com.example.myblog.dto.UserResponse;

public interface UserService {
    UserResponse register(RegisterRequest request);

    UserResponse login(LoginRequest request);

}
