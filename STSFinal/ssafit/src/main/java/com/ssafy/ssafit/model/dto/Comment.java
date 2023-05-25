package com.ssafy.ssafit.model.dto;

import java.sql.Timestamp;

public class Comment {
	private String youtubeId;
	private String nickName;
	private String content;
	private String registDate;
	private int likeCnt;
	private int commentId;
	
	public Comment() {
	}

	public Comment(String youtubeId, String nickName, String content, String registDate, int likeCnt, int commentId) {
		super();
		this.youtubeId = youtubeId;
		this.nickName = nickName;
		this.content = content;
		this.registDate = registDate;
		this.likeCnt = likeCnt;
		this.commentId = commentId;
	}

	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	@Override
	public String toString() {
		return "Comment [youtubeId=" + youtubeId + ", nickName=" + nickName + ", content=" + content + ", registDate="
				+ registDate + ", likeCnt=" + likeCnt + ", commentId=" + commentId + "]";
	}

}