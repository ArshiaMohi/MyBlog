package com.example.myblog.repository;

import com.example.myblog.entity.Comment;
import com.example.myblog.entity.enums.CommentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBlogIdAndStatus(Long id, CommentStatus status);

    Comment findCommentById(Long id);
}
