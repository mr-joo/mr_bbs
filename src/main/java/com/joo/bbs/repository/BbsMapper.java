package com.joo.bbs.repository;

import com.joo.bbs.model.Comment;
import com.joo.bbs.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BbsMapper {
    List<Post> selectList();
    void insertPost(Post post);
    Post selectPost(int postNum);
    void updatePost(Post post);
    void deletePost(int postNum);
    void insertComment(Comment comment);
    List<Comment> selectCommentList(int postNum);
    void updateComment(Comment comment);
    void deleteComment(Comment comment);
    String selectComment(Comment comment);
}
