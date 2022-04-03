package com.blog.api.response.type;

import com.blog.model.Tags;
import lombok.Data;

@Data
public class ListTag {
    private String name;
    private double weight;

    public ListTag(Tags tag) {
        this.name = tag.getName();
        this.weight = 0.0;
    }
}
