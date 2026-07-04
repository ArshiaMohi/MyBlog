package com.example.myblog.service;

import com.example.myblog.dto.BlogRequest;
import com.example.myblog.dto.BlogResponse;
import com.example.myblog.dto.UserResponse;
import com.example.myblog.entity.Blog;

import java.util.List;

public interface BlogService {
    BlogResponse create(BlogRequest request);

    List<BlogResponse> findAll();

    BlogResponse findById(Long id);

    BlogResponse updateBlog(Long id, BlogRequest request);
    List<BlogResponse> deleteBlog(Long id);
}
