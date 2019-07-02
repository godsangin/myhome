package com.myhome.webservice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.webservice.dto.Comment;
@Repository
public class CommentDao {

	@Autowired(required=true)
	private SqlSession sqlSession;
	
	public Comment getComment() {
		return sqlSession.selectOne("com.myhome.CommentMapper.getComment");
	}
}
