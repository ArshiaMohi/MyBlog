package com.example.myblog.dto;

import com.example.myblog.entity.Blog;
import com.example.myblog.entity.enums.BlogStatus;
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
    private BlogStatus status;
    private String authorName;
    private List<CommentResponse> comments;

    public BlogResponse convert(Blog blog){
        BlogResponse response = new BlogResponse();
        response.setId(blog.getId());
        response.setTitle(blog.getTitle());
        response.setContent(blog.getContent());
        response.setCreatedAt(blog.getCreatedAt());
        response.setStatus(blog.getStatus());
        response.setAuthorName(blog.getUser().getName());

        List<CommentResponse> responseList =
                blog.getComments()
                        .stream()
                        .map(comment -> {
                            return new CommentResponse().convert(comment);
                        })
                        .toList();
        response.setComments(responseList);

        return response;
    }
}
