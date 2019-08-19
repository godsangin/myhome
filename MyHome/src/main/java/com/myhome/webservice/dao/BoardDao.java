package com.myhome.webservice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.webservice.dto.Board;

@Repository
public class BoardDao {
	
	@Autowired(required=true)
	private SqlSession sqlSession;
	private String ns = "com.myhome.BoardMapper."; 
	
	public Board getBoardByNum(int b_number) {
		return sqlSession.selectOne(ns + "getBoardByNum", b_number);
	}
	
	public List<Board> getNoticeList(){
		return sqlSession.selectList(ns + "getNoticeList");
	}
	
	public List<Board> getBoardListByPageNum(int page, int limit){
		Map<String, Integer> map = new HashMap<String, Integer>();
//		map.put("b_start", page * 20);
//		map.put("b_limit", 20);
		map.put("b_start", page * limit);
		map.put("b_limit", limit);
		return sqlSession.selectList(ns + "getBoardListByPageNum", map);
	}
	
	public int insertBoard(Board board) {
		int index = -1;
		try {
			index = sqlSession.selectOne(ns + "insertBoard", board);
		}catch(Exception e) {
			e.printStackTrace();
			return index;
		}
		return index;
	}
	
	public boolean updateBoardByNum(Board board) {
		try {
			sqlSession.update(ns + "updateBoardByNum", board);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateViewsByNum(int b_number) {
		try {
			sqlSession.update(ns + "updateViewsByNum", b_number);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateLikesByNum(int b_number) {
		try {
			sqlSession.update(ns + "updateLikesByNum", b_number);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteBoardByNum(int b_number) {
		try {
			sqlSession.delete(ns + "deleteBoardByNum", b_number);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int getTotalPageNum() {
		return sqlSession.selectOne(ns + "getTotalPageNum");
	}
	
	public boolean updateCommentsByNum(int b_number) {
		try {
			sqlSession.update(ns + "updateCommentsByNum", b_number);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
