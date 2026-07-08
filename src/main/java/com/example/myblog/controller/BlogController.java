package com.example.myblog.controller;

import com.example.myblog.dto.BlogRequest;
import com.example.myblog.dto.BlogResponse;
import com.example.myblog.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/findById/{id}")
    public BlogResponse findById(@PathVariable Long id) {
        return blogService.findById(id);
    }

    @GetMapping()
    public List<BlogResponse> findAll() {
        return blogService.findAll();
    }


    @PutMapping("/update/{id}")
    public BlogResponse updateBlog(@PathVariable Long id, @Valid @RequestBody BlogRequest request) {
        return blogService.updateBlog(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public List<BlogResponse> deleteBlog(@PathVariable Long id) {
        return blogService.deleteBlog(id);
    }
}
