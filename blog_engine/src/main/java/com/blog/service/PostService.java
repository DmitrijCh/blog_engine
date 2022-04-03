package com.blog.service;

import com.blog.api.request.PostRequest;
import com.blog.api.response.PostResponse;
import com.blog.repository.PostRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;

    public PostResponse response(PostRequest request) {
        System.out.println(request);
        List<PostResponse> post = new ArrayList<>();
        postRepository.findAll().forEach(p -> post.add(new PostResponse(post)));
        return new PostResponse(post);
    }
}
