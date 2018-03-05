package com.joo.service;

import com.joo.model.Comment;
import com.joo.model.Post;
import com.joo.repository.BbsMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private BbsMapper bbsMapper;


    @Override
    public List<Post> getPostList() {
        return bbsMapper.selectList();
    }

    @Override
    public void writePost(Post post) {
        if (someMandatoryParameterEmpty(post)) {
            throw new IllegalArgumentException("Post is Invalid. post: [" + post + "]");
        } else if (someMandatoryParameterLengthOver(post)) {
            throw new IllegalArgumentException("Post is Invalid. post: [" + post + "]");
        }

        bbsMapper.insertPost(post);
    }

    private boolean someMandatoryParameterEmpty(Post post) {
        return StringUtils.isAnyEmpty(post.getTitle(), post.getMainText(), post.getName());
    }

    private boolean someMandatoryParameterLengthOver(Post post) {
        if (post.getTitle().length() > 20) {
            return true;
        }

        if (post.getMainText().length() > 200) {
            return true;
        }

        if (post.getName().length() > 20) {
            return true;
        }

        return false;
    }

    @Override
    public Post showPost(int postNum) {
        return bbsMapper.selectPost(postNum);
    }

    @Override
    public Post ModifyPost(int postNum, Post post) {
        bbsMapper.updatePost(postNum, post);
        return bbsMapper.selectPost(postNum);
    }

    @Override
    public void removePost(int postNum) {
        bbsMapper.deletePost(postNum);
    }

    @Override
    public void createComment(Comment comment) {
        bbsMapper.insertComment(comment);
    }

    @Override
    public List<Comment> getCommentList(int postNum) {
        return bbsMapper.selectCommentList(postNum);
    }

    @Override
    public String updateComment(Comment comment) {
        bbsMapper.updateComment(comment);
        return bbsMapper.selectComment(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        bbsMapper.deleteComment(comment);
    }
}
