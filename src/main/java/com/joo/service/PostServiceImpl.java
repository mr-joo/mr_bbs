package com.joo.service;

import com.joo.model.Post;
import com.joo.repository.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Override
    public void write(Post post) {
        postDao.insertPost(post);
    }
}
