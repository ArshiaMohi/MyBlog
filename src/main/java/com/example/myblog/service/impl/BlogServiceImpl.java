package com.example.myblog.service.impl;

import com.example.myblog.dto.BlogRequest;
import com.example.myblog.dto.BlogResponse;
import com.example.myblog.dto.CommentResponse;
import com.example.myblog.dto.UserResponse;
import com.example.myblog.entity.Blog;
import com.example.myblog.entity.User;
import com.example.myblog.repository.BlogRepository;
import com.example.myblog.repository.UserRepository;
import com.example.myblog.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public BlogServiceImpl(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BlogResponse create(BlogRequest request) {
        User user = userRepository.findUserById(request.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Blog blog = new Blog().convert(request);
        return new BlogResponse().convert(blogRepository.save(blog));
    }

    @Override
    public List<BlogResponse> findAll() {
        return blogRepository.findAll()
                .stream().map(blog -> {
                    return new BlogResponse().convert(blog);
                })
                .toList();
    }

    @Override
    public BlogResponse findById(Long id) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null){
            throw new RuntimeException("Blog not found");
        }

        return new BlogResponse().convert(blog);
    }

    @Override
    public BlogResponse updateBlog(Long id, BlogRequest request) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null){
            throw new RuntimeException("Blog not found");
        }
        blog.setTitle(request.getTitle());
        blog.setContent(request.getContent());

        Blog updatedBlog = blogRepository.save(blog);
        BlogResponse response = new BlogResponse().convert(updatedBlog);

        return response;
    }

    @Override
    public List<BlogResponse> deleteBlog(Long id) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null){
            throw new RuntimeException("Blog not found");
        }
        blogRepository.delete(blog);
        return blogRepository.findAll().stream()
                .map(b -> {
                    return new BlogResponse().convert(b);
                }).toList();
    }
}
