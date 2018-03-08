package com.joo.bbs.service;

import com.joo.bbs.model.Comment;
import com.joo.bbs.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostList();
    void writePost(Post post);
    Post showPost(int postNum);
    void modifyPost(Post post);
    void removePost(int postNum);
    void createComment(Comment comment);
    List<Comment> getCommentList(int postNum);
    void updateComment(Comment comment);
    void removeComment(Comment comment);
}
