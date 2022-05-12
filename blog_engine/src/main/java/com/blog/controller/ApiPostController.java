package com.blog.controller;

import com.blog.api.request.LikeRequest;
import com.blog.api.request.PostRequest;
import com.blog.api.response.PostResponse;
import com.blog.api.response.ResultResponse;
import com.blog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiPostController {
    private PostService postService;

    @GetMapping(value = {"/post", "/post/search", "/post/byDate", "/post/byTag"})
    public ResponseEntity<PostResponse> get(PostRequest request) {
        return ResponseEntity.ok(postService.response(request));
    }

    @PostMapping("/post/like")
    public ResponseEntity<ResultResponse> like(@RequestBody LikeRequest request) {
        return ResponseEntity.ok(postService.like(true, request.getPostId()));
    }

    @PostMapping("/post/dislike")
    public ResponseEntity<ResultResponse> dislike(@RequestBody LikeRequest request) {
        return ResponseEntity.ok(postService.like(false, request.getPostId()));
    }
}