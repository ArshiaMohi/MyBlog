package com.example.myblog.service;

import com.example.myblog.dto.CommentRequest;
import com.example.myblog.dto.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentResponse create(CommentRequest request);
    List<CommentResponse> findAll();
    List<CommentResponse> findByBlog(Long id);
    CommentResponse accept(Long id);
    CommentResponse reject(Long id);

}
