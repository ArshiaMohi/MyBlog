//package com.example.myblog.controller;
////
////import com.example.myblog.dto.CommentRequest;
////import com.example.myblog.dto.CommentResponse;
////import com.example.myblog.service.CommentService;
////import jakarta.validation.Valid;
////import org.springframework.web.bind.annotation.*;
////
////@RestController
////@RequestMapping("/comments")
////public class CommentController {
////    private final CommentService commentService;
////
////    public CommentController(CommentService commentService) {
////        this.commentService = commentService;
////    }
////
////    @PostMapping()
////    public CommentResponse create(@Valid @RequestBody CommentRequest request){
////        return commentService.create(request);
////    }
////}
