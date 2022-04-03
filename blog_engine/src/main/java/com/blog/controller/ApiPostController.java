package com.blog.controller;

import com.blog.api.request.PostRequest;
import com.blog.api.response.PostResponse;
import com.blog.service.PostService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiPostController {
    private PostService postService;

    @GetMapping("/post")
    public PostResponse get(PostRequest request) {
        return postService.response(request);
    }
}

