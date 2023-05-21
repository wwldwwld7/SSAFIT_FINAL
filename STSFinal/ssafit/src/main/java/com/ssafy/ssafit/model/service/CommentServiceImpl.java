package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.CommentDao;
import com.ssafy.ssafit.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentDao commentDao;
	
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	@Override
	public int registComment(Comment comment) {
		return commentDao.insertComment(comment);
	}

	@Override
	public List<Comment> searchCommentByVideo(String youtubeId) {
		return commentDao.selectCommentByVideo(youtubeId);
	}

	@Override
	public List<Comment> searchCommentByUser(String nickName) {
		return commentDao.selectCommentByUser(nickName);
	}

	@Override
	public int modifyComment(Comment comment) {
		return commentDao.updateComment(comment);
	}

	@Override
	public int removeComment(int commentId) {
		return commentDao.deleteComment(commentId);
	}

}
