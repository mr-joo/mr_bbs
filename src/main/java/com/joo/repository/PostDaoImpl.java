package com.joo.repository;

import com.joo.model.Post;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl implements PostDao{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void insertPost(Post post) {
        sqlSession.insert("write", post);
    }
}
