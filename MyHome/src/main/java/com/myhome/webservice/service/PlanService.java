package com.myhome.webservice.service;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.webservice.dao.PlanDao;
import com.myhome.webservice.dto.Plan;

@Service
public class PlanService{
	
	@Autowired(required=true)
	private PlanDao plandao;
	
	public List<Plan> getPlansByMonth(String m_start){
		List<Plan> thisMonthPlan = new ArrayList<>();
		int m_endInteger = Integer.parseInt(m_start);
		m_endInteger = m_endInteger + 30;
		String m_end = String.valueOf(m_endInteger);
		Map<String, String> map = new HashMap<>();
		map.put("m_start", m_start);
		map.put("m_end", m_end);
		thisMonthPlan = plandao.getPlansByMonth(map);
		return thisMonthPlan;
	}
	
	public boolean insertPlan(Plan plan) {
		return plandao.insertPlan(plan);
	}
	
	public Plan getPlanByNum(int p_number) {
		return plandao.getPlanByNum(p_number);
	}
	
	public boolean updatePlan(Plan plan) {
		return plandao.updatePlan(plan);
	}
	
	public boolean deletePlanByNum(int p_number) {
		return plandao.deletePlanByNum(p_number);
	}
	
}
