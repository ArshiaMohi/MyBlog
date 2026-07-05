package com.example.myblog.dto;

import com.example.myblog.entity.Comment;
import com.example.myblog.entity.enums.CommentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponse {
    private Long id;
    private String text;
    private String userName;
    private CommentStatus status;
    private Long idOfBlog;

    public CommentResponse convert(Comment comment){
        CommentResponse response = new CommentResponse();
        response.setId(comment.getId());
        response.setText(comment.getText());
        response.setUserName(comment.getUser().getName());
        response.setStatus(comment.getStatus());
        response.setIdOfBlog(comment.getIdOfBlog());
        return response;
    }
}
