package com.joo.repository;

import com.joo.model.Post;
import org.apache.ibatis.annotations.Mapper;

public interface PostDao {
    public void insertPost(Post post);
}
