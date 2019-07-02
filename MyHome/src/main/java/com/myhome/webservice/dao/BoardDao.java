package com.myhome.webservice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.webservice.dto.Board;

@Repository
public class BoardDao {
	@Autowired(required=true)
	private SqlSession sqlSession;
	private String ns = "com.myhome.BoardMapper."; 
	
	public Board getBoardByNum(int num) {
		return sqlSession.selectOne(ns + "getBoard");
	}
	
}
