package com.joo.service;

import com.joo.model.Comment;
import com.joo.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostList();
    void writePost(Post post);
    Post showPost(int postNum);
    Post ModifyPost(int postNum, Post post);
    void removePost(int postNum);
    void createComment(Comment comment);
    List<Comment> getCommentList(int postNum);
    String updateComment(Comment comment);
    void removeComment(Comment comment);
}
