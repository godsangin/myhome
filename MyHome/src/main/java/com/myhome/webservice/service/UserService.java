package com.myhome.webservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.webservice.dao.UserDao;
import com.myhome.webservice.dto.User;

@Service
public class UserService{
	
	@Autowired(required=true)
	private UserDao userdao;
	public void addUser(User user) {
		userdao.insertUser(user);
	}
	
	public User getUserByMail(String u_mail) {
		return userdao.getUserByMail(u_mail);
	}
	
	public boolean checkPassword(String u_mail, String u_password) {
		User user = userdao.getUserByMail(u_mail);
		if(user == null) {
			return false;
		}
		if(user.getU_pw().equals(u_password)) {
			return true;
		}
		return false;
	}
	
	public boolean updateUserInfo(User user) {
		return userdao.updateUserInfo(user);
	}
	
	public boolean updateUserPW(User user) {
		return userdao.updateUserPW(user);
	}
}
