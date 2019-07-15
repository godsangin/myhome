package com.myhome.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.myhome.webservice.dao.AttachmentDao;
import com.myhome.webservice.dao.BoardDao;
import com.myhome.webservice.dao.CommentDao;

public class BoardService {
	@Autowired(required=true)
	private BoardDao boardDao;
	@Autowired(required=true)
	private CommentDao commentDao;
	@Autowired(required=true)
	private AttachmentDao attachmentDao;
	
	
}
