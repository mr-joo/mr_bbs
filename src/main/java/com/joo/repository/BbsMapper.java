package com.joo.repository;

import com.joo.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsMapper {
    void insert(Post post);
}
