package com.myhome.webservice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.webservice.dto.Plan;
@Repository
public class PlanDao {
	private String ns = "com.myhome.PlanMapper.";
	
	@Autowired(required=true)
	private SqlSession sqlSession;
	
	public List<Plan> selectAllPlan(){
		List<Plan> plans;
		try {
			plans = sqlSession.selectList(ns + "getAllPlans");			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return plans;
	}
	
	
	public boolean insertPlan(Plan plan) {
		try {
			sqlSession.insert(ns + "insertPlan", plan);			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Plan> getPlansByMonth(Map<String, String> month){
		List<Plan> monthPlans;
		try {
			monthPlans = sqlSession.selectList(ns + "getPlansByMonth", month);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return monthPlans;
	}
	
	public Plan getPlanByNum(int p_number) {
		Plan p;
		try {
			p = sqlSession.selectOne("getPlanByNum", p_number);			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return p;
	}
	
	public boolean updatePlan(Plan plan) {
		try {
			sqlSession.update("updatePlan", plan);
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deletePlanByNum(int p_number) {
		try {
			sqlSession.delete("deletePlanByNum", p_number);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}
