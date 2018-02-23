package com.joo.service;

import com.joo.model.Post;
import com.joo.repository.BbsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private BbsMapper bbsMapper;

    @Override
    public void write(Post post) {
        //TODO: 욕설 치환 기능 추가
        bbsMapper.insert(post);
    }
}
