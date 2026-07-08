package com.example.myblog.dto;

import com.example.myblog.entity.Blog;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BlogResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;


    public BlogResponse convert(Blog blog){
        BlogResponse response = new BlogResponse();
        response.setId(blog.getId());
        response.setTitle(blog.getTitle());
        response.setContent(blog.getContent());
        response.setCreatedAt(blog.getCreatedAt());

        return response;
    }
}
