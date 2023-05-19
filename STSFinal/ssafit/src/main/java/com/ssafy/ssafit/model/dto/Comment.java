package com.ssafy.ssafit.model.dto;

import java.sql.Timestamp;

public class Comment {
	private String youtubeId;
	private String writer;
	private String content;
	private Timestamp registDate;
	private int likeCnt;
	private int commentId;
	
	public Comment() {
	}

	public Comment(String youtubeId, String writer, String content, Timestamp registDate, int likeCnt, int commentId) {
		super();
		this.youtubeId = youtubeId;
		this.writer = writer;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Timestamp registDate) {
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
		return "Comment [youtubeId=" + youtubeId + ", writer=" + writer + ", content=" + content + ", registDate="
				+ registDate + ", likeCnt=" + likeCnt + ", commentId=" + commentId + "]";
	}
	
	
}
