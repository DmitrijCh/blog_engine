package com.blog.service;

import com.blog.api.request.TagRequest;
import com.blog.api.response.TagResponse;
import lombok.AllArgsConstructor;
import com.blog.api.response.type.ListTag;
import com.blog.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TagService {

    private TagRepository tagRepository;

    public TagResponse response(TagRequest request) {
        System.out.println(request);
        List<ListTag> tags = new ArrayList<>();
        tagRepository.findAll().forEach(t -> tags.add(new ListTag(t)));
        return new TagResponse(tags);
    }
}
