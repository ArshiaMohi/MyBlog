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
    private CommentStatus status;

    public CommentResponse convert(Comment comment){
        CommentResponse response = new CommentResponse();
        response.setId(comment.getId());
        response.setText(comment.getText());
        response.setStatus(comment.getStatus());
        return response;
    }
}
