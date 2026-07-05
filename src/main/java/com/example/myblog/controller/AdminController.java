package com.example.myblog.controller;

import com.example.myblog.dto.CommentResponse;
import com.example.myblog.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final CommentService commentService;

    public AdminController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping()
    public List<CommentResponse> findAll() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public List<CommentResponse> findByBlog(@PathVariable Long id) {
        return commentService.findByBlog(id);
    }

    @PutMapping("/accept/{id}")
    public CommentResponse accept(@PathVariable Long id){
        return commentService.accept(id);
    }

    @PutMapping("/reject/{id}")
    public CommentResponse reject(@PathVariable Long id){
        return commentService.reject(id);
    }
}
