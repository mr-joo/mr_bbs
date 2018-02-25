package com.joo.repository;

import com.joo.model.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BbsMapper {
    List<Post> selectList();
    void insert(Post post);
    Post selectPost(int postNum);
    void updatePost(@Param("postNum") int postNum, @Param("post") Post post);
    void deletePost(int postNum);
}
