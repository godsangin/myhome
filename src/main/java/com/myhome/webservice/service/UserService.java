package com.myhome.webservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.webservice.dao.UserDao;

@Service
public class UserService{
	
	@Autowired(required=true)
	private UserDao userdao;
	
}
