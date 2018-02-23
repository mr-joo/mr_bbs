package com.joo.repository;

import com.joo.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BbsMapper {
    List<Post> selectList();
    void insert(Post post);
    Post selectPost(int postNum);
}
