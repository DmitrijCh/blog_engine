package com.blog.repository;

import com.blog.model.Tags;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tags, Integer> {
}
