package com.example.myblog.controller;

import com.example.myblog.dto.BlogRequest;
import com.example.myblog.dto.LoginRequest;
import com.example.myblog.dto.RegisterRequest;
import com.example.myblog.entity.enums.Role;
import com.example.myblog.service.BlogService;
import com.example.myblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    private final UserService userService;
    private final BlogService blogService;

    public PageController(UserService userService, BlogService blogService) {
        this.userService = userService;
        this.blogService = blogService;
    }

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("users/login")
    public String loginAccept(@RequestParam String email, @RequestParam String password){
        LoginRequest request = new LoginRequest();
        request.setEmail(email);
        request.setPassword(password);
        try {
            userService.login(request);
        }catch (Exception e){
            return "login";
        }
        return "home";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("users/register")
    public String registerAccept(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam Role role
            ){
        RegisterRequest request = new RegisterRequest();
        request.setName(name);
        request.setEmail(email);
        request.setPassword(password);
        request.setRole(role);
        try {
            userService.register(request);
        }catch (Exception e){
            return "register";
        }
        return "home";
    }

    @GetMapping("/createBlog")
    public String createBlog(){
        return "createBlog";
    }
    @PostMapping("/blogs/createBlog")
    public String createBlogAccept(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam Long userId
    ){
        BlogRequest request = new BlogRequest();
        request.setTitle(title);
        request.setContent(content);
        request.setUserId(userId);
        try {
            blogService.create(request);
        }catch (Exception e){
            return "createBlog";
        }
        return "blogs";
    }


}
