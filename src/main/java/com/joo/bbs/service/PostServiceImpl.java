package com.joo.bbs.service;

import com.joo.bbs.repository.BbsMapper;
import com.joo.bbs.model.Comment;
import com.joo.bbs.model.Post;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private static final int MAX_LENGTH_TITLE = 20;
    private static final int MAX_LENGTH_MAIN_TEXT = 200;
    private static final int MAX_LENGTH_NAME = 20;

    @Autowired
    private BbsMapper bbsMapper;


    @Override
    public List<Post> getPostList() {
        return bbsMapper.selectList();
    }

    @Override
    public boolean createPost(Post post) {
        if (isAnyEmptySomeMandatory(post)) {
            throw new IllegalArgumentException("SomeMandatoryParameter is empty. post: [" + post + "]");
        }

        if (containsOverLengthParam(post)) {
            throw new IllegalArgumentException("SomeMandatoryParameter is LengthOver. post: [" + post + "]");
        }

        return bbsMapper.insertPost(post) == 1;
    }

    private boolean isAnyEmptySomeMandatory(Post post) {
        return ObjectUtils.isEmpty(post) || StringUtils.isAnyEmpty(post.getTitle(), post.getMainText(), post.getName());
    }

    private boolean containsOverLengthParam(Post post) {
        if (StringUtils.length(post.getTitle()) > MAX_LENGTH_TITLE) {
            return true;
        }

        if (StringUtils.length(post.getMainText()) > MAX_LENGTH_MAIN_TEXT) {
            return true;
        }

        if (StringUtils.length(post.getName()) > MAX_LENGTH_NAME) {
            return true;
        }

        return false;
    }

    @Override
    public Post getPost(int postNum) {
        return bbsMapper.selectPost(postNum);
    }

    @Override
    public void modifyPost(Post post) {
        bbsMapper.updatePost(post);
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
    public void updateComment(Comment comment) {
        bbsMapper.updateComment(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        bbsMapper.deleteComment(comment);
    }
}
