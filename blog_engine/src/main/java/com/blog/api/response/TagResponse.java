package com.blog.api.response;

import com.blog.api.response.type.ListTag;
import lombok.Data;

import java.util.List;


@Data
public class TagResponse {
    private List<ListTag> tags;

    public TagResponse(List<ListTag> tags) {
        this.tags = tags;
    }

    public void add(List<ListTag> tags) {
        this.tags.addAll(tags);
    }

}
