package com.example.myblog.service.impl;

import com.example.myblog.dto.LoginRequest;
import com.example.myblog.dto.RegisterRequest;
import com.example.myblog.dto.UserResponse;
import com.example.myblog.entity.User;
import com.example.myblog.repository.UserRepository;
import com.example.myblog.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse register(RegisterRequest request) {
        User existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("Email already exists");
        }
        User user = new User().convert(request);
        User savedUser = userRepository.save(user);

        UserResponse response = new UserResponse().convert(savedUser);

        return response;

    }

    @Override
    public UserResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Password is wrong");
        }

        UserResponse response = new UserResponse().convert(user);

        return response;
    }
}
