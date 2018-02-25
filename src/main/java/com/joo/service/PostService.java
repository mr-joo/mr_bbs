package com.joo.service;

import com.joo.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostList();
    void write(Post post);
    Post showPost(int postNum);
    Post updatePost(int postNum, Post post);
    void deletePost(int postNum);
}
