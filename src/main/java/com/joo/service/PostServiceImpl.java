package com.joo.service;

import com.joo.model.Post;
import com.joo.repository.BbsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    public void write(Post post) {
        //TODO: 제목, 내용 길이제한 체크 기능 추가
        bbsMapper.insert(post);
    }

    @Override
    public Post showPost(int postNum) {
        return bbsMapper.selectPost(postNum);
    }
}
