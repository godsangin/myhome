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
	
	public boolean insertUser(User user) {
		try {
			sqlSession.insert(ns + "insertUser", user);			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public User getUserByMail(String u_mail) {
		User user = null;
		try {
			user = sqlSession.selectOne(ns + "getUserByMail", u_mail);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	public boolean updateUserInfo(User user) {
		try {
			sqlSession.update(ns + "updateUserInfo", user);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateUserPW(User user) {
		try {
			sqlSession.update(ns + "updateUserPW", user);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}
