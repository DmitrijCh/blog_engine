package com.blog.service;

import com.blog.api.request.CalendarRequest;
import com.blog.api.response.CalendarResponse;
import com.blog.model.query.PostCount;
import com.blog.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalendarService {
    private final PostRepository postRepository;

    public CalendarResponse response(CalendarRequest request) {
        List<Integer> years = postRepository.getAllYear();
        List<PostCount> posts = postRepository.getCountByYear(request.getYear());

        return new CalendarResponse(
                years,
                posts.stream().collect(Collectors.toMap(PostCount::getDate, PostCount::getCount))
        );
    }
}

