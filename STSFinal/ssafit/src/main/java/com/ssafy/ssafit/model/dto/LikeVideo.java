package com.ssafy.ssafit.model.dto;

public class LikeVideo {
	private String nickName;
	private String youtubeId;
	private int likeVideoId;
	
	public LikeVideo() {
	}

	public LikeVideo(String nickName, String youtubeId, int likeVideoId) {
		super();
		this.nickName = nickName;
		this.youtubeId = youtubeId;
		this.likeVideoId = likeVideoId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}

	public int getLikeVideoId() {
		return likeVideoId;
	}

	public void setLikeVideoId(int likeVideoId) {
		this.likeVideoId = likeVideoId;
	}

	@Override
	public String toString() {
		return "LikeVideo [nickName=" + nickName + ", youtubeId=" + youtubeId + ", likeVideoId=" + likeVideoId + "]";
	}
	
}
