package com.myhome.webservice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.webservice.dto.Attachment;
import com.myhome.webservice.dto.Board;

@Repository
public class AttachmentDao {
	
	@Autowired(required=true)
	private SqlSession sqlSession;
	private String ns = "com.myhome.AttachmentMapper.";
	
	public List<Attachment> getAttachmentListByBoardNum(int b_number){
		return sqlSession.selectList(ns + "getAttachmentListByBoardNum", b_number);
	}
	
	public int getTotalPageNum() {
		return sqlSession.selectOne(ns + "getTotalPageNum");
	}
	
	public List<Attachment> getAttachmentListByPageNum(int page){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a_start", page * 20);
		map.put("a_limit", 20);
		return sqlSession.selectList(ns + "getAttachmentListByPageNum", map);
	}
	
	public boolean insertAttachment(List<Attachment> attachments) {
		if(attachments == null) {
			return true;
		}
		try {
			for(Attachment attachment:attachments) {
				sqlSession.insert(ns + "insertAttachment", attachment);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateAttachment(Attachment attachment) {
		try {
			sqlSession.update(ns + "updateAttachment", attachment);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean deleteAttachmentByBoardNum(int b_number) {
		try {
			sqlSession.delete(ns + "deleteAttachmentByBoardNum", b_number);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}
