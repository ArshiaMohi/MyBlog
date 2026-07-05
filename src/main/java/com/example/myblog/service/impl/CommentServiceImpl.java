package com.example.myblog.service.impl;

import com.example.myblog.dto.CommentRequest;
import com.example.myblog.dto.CommentResponse;
import com.example.myblog.entity.Blog;
import com.example.myblog.entity.Comment;
import com.example.myblog.entity.User;
import com.example.myblog.entity.enums.CommentStatus;
import com.example.myblog.repository.BlogRepository;
import com.example.myblog.repository.CommentRepository;
import com.example.myblog.repository.UserRepository;
import com.example.myblog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(UserRepository userRepository, BlogRepository blogRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.blogRepository = blogRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentResponse create(CommentRequest request) {
        User user = userRepository.findUserById(request.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Blog blog = blogRepository.findBlogById(request.getBlogId());
        if (blog == null) {
            throw new RuntimeException("Blog not found");
        }
        Comment comment = new Comment().convert(request);
        comment.setUser(user);
        Comment savedComment = commentRepository.save(comment);

        CommentResponse response = new CommentResponse().convert(savedComment);
        return response;
    }

    @Override
    public List<CommentResponse> findAll() {
        return commentRepository.findAll()
                .stream().map(comment -> {
                    return new CommentResponse().convert(comment);
                })
                .toList();
    }

    @Override
    public List<CommentResponse> findByBlog(Long id) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null){
            throw new RuntimeException("Blog not found");
        }
        return blog.getComments()
                .stream().map(comment -> {
                    return new CommentResponse().convert(comment);
                })
                .toList();
    }

    @Override
    public CommentResponse accept(Long id) {
        Comment comment = commentRepository.findCommentById(id);
        if (comment == null){
            throw new RuntimeException("Comment not found");
        }
        Blog blog = blogRepository.findBlogById(comment.getIdOfBlog());
        if (blog == null){
            throw new RuntimeException("Blog not found");
        }

        comment.setStatus(CommentStatus.APPROVED);
        comment.setBlog(blog);
        List<Comment> comments = blog.getComments();
        comments.add(comment);
        blog.setComments(comments);
        blogRepository.save(blog);

        return new CommentResponse().convert(comment);
    }

    @Override
    public CommentResponse reject(Long id) {
        Comment comment = commentRepository.findCommentById(id);
        if (comment == null){
            throw new RuntimeException("Comment not found");
        }
        comment.setStatus(CommentStatus.REJECTED);

        return new CommentResponse().convert(comment);
    }
}
