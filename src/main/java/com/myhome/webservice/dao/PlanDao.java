package com.myhome.webservice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.webservice.dto.Plan;
@Repository
public class PlanDao {
	private String ns = "com.myhome.PlanMapper.";
	
	@Autowired(required=true)
	private SqlSession sqlSession;
}
