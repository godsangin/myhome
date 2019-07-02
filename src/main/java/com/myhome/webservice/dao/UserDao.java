package com.myhome.webservice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.webservice.dto.User;
@Repository
public class UserDao {
	private String ns = "com.myhome.UserMapper.";
	
	@Autowired(required=true)
	private SqlSession sqlSession;
}
