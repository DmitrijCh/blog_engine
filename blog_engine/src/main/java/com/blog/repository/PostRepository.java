package com.blog.repository;


import com.blog.model.Posts;
import com.blog.model.enums.ModerationStatus;
import com.blog.model.query.PostCount;
import com.sun.istack.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Posts, Integer> {
    long countByModerationStatus(ModerationStatus status);

    @Query(
            value = "SELECT DISTINCT YEAR(time) AS year FROM posts",
            nativeQuery = true
    )
    List<Integer> getAllYears();

    @Query(
            value = "SELECT DATE(time) AS date, COUNT(1) as count FROM posts WHERE YEAR(time) = ?1 GROUP BY DATE(time)",
            nativeQuery = true
    )
    List<PostCount> getCountByYear(int year);

    @Query(
            value = "SELECT COUNT(1) AS count FROM posts p " +
                    "LEFT JOIN tag2post t2p ON p.id = t2p.post_id AND ?3 IS NOT NULL " +
                    "LEFT JOIN tags t ON t2p.tag_id = t.id AND ?3 IS NOT NULL " +
                    "WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND time <= NOW() " +
                    "      AND (UPPER(title) LIKE UPPER(CONCAT('%', ?1, '%')) OR UPPER(text) LIKE UPPER(CONCAT('%', ?1, '%'))) " +
                    "      AND (DATE(p.time) = ?2 OR ?2 IS NULL) " +
                    "      AND (t.name = ?3 OR ?3 IS NULL)",
            nativeQuery = true
    )
    long countPostSearch(@NotNull String search, String byDate, String tag);

    List<Integer> getAllYear();
}







