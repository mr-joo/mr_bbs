package com.joo.service;

import com.joo.model.Comment;
import com.joo.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostList();
    void writePost(Post post);
    Post showPost(int postNum);
    Post updatePost(int postNum, Post post);
    void deletePost(int postNum);
    void insertComment(Comment comment);
    List<Comment> getCommentList(int postNum);
    String updateComment(Comment comment);
    void deleteComment(Comment comment);
}
