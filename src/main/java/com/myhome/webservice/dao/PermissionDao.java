package com.myhome.webservice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.webservice.dto.Permission;
@Repository
public class PermissionDao {
	private String ns = "com.myhome.PermissionMapper.";
	
	@Autowired(required=true)
	private SqlSession sqlSession;
	
	public Permission getPermission() {
		return sqlSession.selectOne(ns + "getPermission");
	}
}
