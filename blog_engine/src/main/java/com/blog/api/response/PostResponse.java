package com.blog.api.response;

import com.blog.api.response.type.ListPost;
import lombok.Data;
import java.util.List;

@Data
public class PostResponse {
    private List<ListPost> posts;
    private long count;

    public PostResponse(List<ListPost> posts) {
        this.posts = posts;
    }

    public void add(List<ListPost> posts) {
        this.posts.addAll(posts);
    }
}