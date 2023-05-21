package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Comment;

public interface CommentDao {
	
	//댓글 작성
	int insertComment(Comment comment);
	
	//해당 영상에 달린 댓글들 불러와 ~
	List<Comment> selectCommentByVideo(String youtubeId);
	
	//해당 유저가 남긴 댓글들 불러와~
	List<Comment> selectCommentByUser(String nickName);
	
	//댓글 내용 수정
	int updateComment(Comment comment);
	
	//댓글 삭제
	int deleteComment(int commentId);
	
}
