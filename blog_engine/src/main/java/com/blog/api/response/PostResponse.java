package com.blog.api.response;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostResponse {
    private List<PostResponse> posts;

    public PostResponse() {
        posts = new ArrayList<>();
    }

    public PostResponse(List<PostResponse> posts) {
        this.posts = posts;
    }

    public void add(List<PostResponse> posts) {
        this.posts.addAll(posts);
    }

    @JsonGetter("count")
    public int count() {
        return posts.size();
    }
}
