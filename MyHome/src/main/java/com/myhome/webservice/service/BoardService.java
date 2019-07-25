package com.myhome.webservice.service;

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
	
	public boolean insertBoard(Board board, List<Attachment> attachments) {
		System.out.println("service" + board);
		if(attachments == null) {
			
		}
		if(!boardDao.insertBoard(board)) {
			return false;
		}
		return attachmentDao.insertAttachment(attachments);
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
	
	public boolean likeupdate(Board board) {
		return boardDao.updateLikesByNum(board);
	}
	
	public boolean viewupdate(Board board) {
		return boardDao.updateViewsByNum(board);
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
