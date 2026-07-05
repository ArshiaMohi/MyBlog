package com.example.myblog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    @NotBlank(message = "Text is required")
    private String text;
    private Long blogId;
    private Long userId;
}
