package com.myhome.webservice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myhome.webservice.dto.Comment;
@Repository
public class CommentDao {
	@Autowired(required=true)
	private SqlSession sqlSession;
	private String ns = "com.myhome.CommentMapper.";
	
	public List<Comment> getCommentListByBoardNum(int b_number) {
		return sqlSession.selectList(ns + "getCommentListByBoardNum", b_number);
	}
	
	public boolean insertComment(Comment comment) {
		try {
			sqlSession.insert(ns + "insertComment", comment);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean updateComment(Comment comment) {
		try {
			sqlSession.update(ns + "updateComment", comment);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean deleteCommentByNum(int c_number) {
		try {
			sqlSession.delete(ns + "deleteCommentByNum", c_number);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean deleteCommentByBoardNum(int b_number) {
		try {
			sqlSession.delete(ns + "deleteCommentByNum", b_number);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
}
