package com.joo.service;

import com.joo.model.Comment;
import com.joo.model.Post;
import com.joo.repository.BbsMapper;
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
        //TODO: 제목, 내용 길이제한 체크 기능 추가
        bbsMapper.insertPost(post);
    }

    @Override
    public Post showPost(int postNum) {
        return bbsMapper.selectPost(postNum);
    }

    @Override
    public Post updatePost(int postNum, Post post) {
        bbsMapper.updatePost(postNum, post);
        return bbsMapper.selectPost(postNum);
    }

    @Override
    public void deletePost(int postNum) {
        bbsMapper.deletePost(postNum);
    }

    @Override
    public void insertComment(Comment comment) {
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
}
