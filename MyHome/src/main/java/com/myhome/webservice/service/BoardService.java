package com.myhome.webservice.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.webservice.dao.AttachmentDao;
import com.myhome.webservice.dao.BoardDao;
import com.myhome.webservice.dao.CommentDao;
import com.myhome.webservice.dto.Attachment;
import com.myhome.webservice.dto.Board;
import com.myhome.webservice.dto.Comment;

@Service
public class BoardService {
	@Autowired(required=true)
	private BoardDao boardDao;
	@Autowired(required=true)
	private CommentDao commentDao;
	@Autowired(required=true)
	private AttachmentDao attachmentDao;
	
	public Board getBoardByNum(int b_number) {
		return boardDao.getBoardByNum(b_number);
	}
	
	public List<Board> getBoardsByPageNum(int page_num){
		return boardDao.getBoardListByPageNum(page_num);
	}
	
	public int getTotalPageNum() {
		return boardDao.getTotalPageNum();
	}
	public List<Attachment> getAttachmentsByPageNum(int page_num){
		return attachmentDao.getAttachmentListByPageNum(page_num);
	}
	public int getGalleryTotalPageNum() {
		return attachmentDao.getTotalPageNum();
	}
	
	public boolean insertBoard(Board board, List<String> attachments) {
		System.out.println("service" + board);
		if(attachments == null) {
			
		}
		int index = boardDao.insertBoard(board);
		System.out.println(index);
		if(index == -1) {
			return false;
		}
		List<Attachment> ats = new ArrayList<Attachment>();
		for(String str: attachments) {
			if(str.equals("")) break;
			ats.add(new Attachment(-1, index, str));
		}
		return attachmentDao.insertAttachment(ats);
	}
	
	public boolean updateBoard(Board board, List<Attachment> attachments) {
		if(!boardDao.updateBoardByNum(board)) {
			return false;
		}
		if(!attachmentDao.deleteAttachmentByBoardNum(board.getB_number())) {
			return false;
		}
		return attachmentDao.insertAttachment(attachments);
	}
	
	public boolean updateLike(int b_number) {
		return boardDao.updateLikesByNum(b_number);
	}
	
	public boolean updateViews(int b_number) {
		return boardDao.updateViewsByNum(b_number);
	}
	
	public boolean updateComments(int b_number) {
		return boardDao.updateCommentsByNum(b_number);
	}
	
	public boolean deleteBoardByNum(int b_number) {
		if(!boardDao.deleteBoardByNum(b_number)) {
			return false;
		}
		if(!commentDao.deleteCommentByBoardNum(b_number)) {
			return false;
		}
		return attachmentDao.deleteAttachmentByBoardNum(b_number); 
	}
	
	public List<Attachment> getAttachmentListByBoardNum(int b_number){
		return attachmentDao.getAttachmentListByBoardNum(b_number);
	}
	
	/**
	 * comments
	 */
	public boolean insertComment(Comment comment) {
		return commentDao.insertComment(comment);
	}
	
	public boolean updateComment(Comment comment) {
		return commentDao.updateComment(comment);
	}
	
	public List<Comment> getCommentListByBoardNum(int b_number){
		return commentDao.getCommentListByBoardNum(b_number);
	}
}
