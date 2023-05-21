package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Comment;

public interface CommentService {
	
	//댓글 작성
	int registComment(Comment comment);
	
	//해당 영상에 달린 댓글들 불러와 ~
	List<Comment> searchCommentByVideo(String youtubeId);
	
	//해당 유저가 남긴 댓글들 불러와~
	List<Comment> searchCommentByUser(String nickName);
	
	//댓글 내용 수정
	int modifyComment(Comment comment);
	
	//댓글 삭제
	int removeComment(int commentId);
	
}
