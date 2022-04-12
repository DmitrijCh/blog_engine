package com.blog.service;

import com.blog.api.request.PostRequest;
import com.blog.api.response.PostResponse;
import com.blog.api.response.type.ListPost;
import com.blog.model.Posts;
import com.blog.model.enums.ModerationStatus;
import com.blog.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final EntityManager entityManager;

    public PostResponse response(PostRequest request) {
        String search = Optional.ofNullable(request.getQuery()).orElse("");
        String mode = Optional.ofNullable(request.getMode()).orElse("recent");
        String byDate = request.getDate();
        String tag = request.getTag();

        List<ListPost> posts = entityManager
                .createNamedQuery("PostWithStat", Tuple.class)
                .setParameter("offset", request.getOffset())
                .setParameter("limit", request.getLimit())
                .setParameter("sortType", mode)
                .setParameter("search", search)
                .setParameter("byDate", byDate)
                .setParameter("tag", tag)
                .getResultStream()
                .map(p -> {
                    ListPost post = new ListPost((Posts) p.get(0));
                    post.setCommentCount((int) p.get(1));
                    post.setLikeCount((int) p.get(2));
                    post.setDislikeCount((int) p.get(3));
                    return post;
                })
                .collect(Collectors.toList());
        PostResponse listPostResponse = new PostResponse(posts);
        listPostResponse.setCount(postRepository.countPostSearch(search, byDate, tag));

        return listPostResponse;
    }

    public long countPostInModeration() {
        return postRepository.countByModerationStatus(ModerationStatus.NEW);
    }
}
