package com.example.myblog.entity;

import com.example.myblog.dto.CommentRequest;
import com.example.myblog.entity.enums.CommentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private Long idOfBlog;
    @Enumerated(EnumType.STRING)
    private CommentStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    public Comment convert(CommentRequest request){
        Comment comment = new Comment();
        comment.setText(request.getText());
        comment.setStatus(CommentStatus.PENDING);
        comment.setIdOfBlog(request.getBlogId());
        return comment;
    }
}
