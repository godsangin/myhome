package com.myhome.webservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.webservice.dao.PermissionDao;
import com.myhome.webservice.dto.Permission;

@Service
public class PermissionService{
	
	@Autowired(required=true)
	private PermissionDao permissiondao;
	
	public Permission getPermission() {
		// TODO Auto-generated method stub
		return permissiondao.getPermission();
	}
	
}
