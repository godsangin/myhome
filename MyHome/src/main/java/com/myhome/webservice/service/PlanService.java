package com.myhome.webservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.webservice.dao.PlanDao;

@Service
public class PlanService{
	
	@Autowired(required=true)
	private PlanDao plandao;
	
}
