package com.myhome.webservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.webservice.dao.CommentDao;
import com.myhome.webservice.dto.Comment;

@Service("commentservice")
public class CommentService {
	
	@Autowired(required=true)
	private CommentDao commentdao;
	
	public Comment getComment() {
		// TODO Auto-generated method stub
		return commentdao.getComment();
	}
	
}