package com.myhome.webservice.comment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentservice")
public class CommentServiceImpl implements CommentService{
	@Autowired(required=true)
	private SqlSession sqlSession;
	
	@Override
	public Comment getComment() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.myhome.CommentMapper.getComment");
	}
	
}
