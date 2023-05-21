package com.ssafy.ssafit.model.dto;

public class Video {
	private String youtubeId;
	private String channelName;
	private String title;
	private int viewCnt;
	private String thumbnails;
	
	public Video() {
	}

	public Video(String youtubeId, String channelName, String title, int viewCnt, String thumbnails) {
		super();
		this.youtubeId = youtubeId;
		this.channelName = channelName;
		this.title = title;
		this.viewCnt = viewCnt;
		this.thumbnails = thumbnails;
	}

	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}

	@Override
	public String toString() {
		return "Video [youtubeId=" + youtubeId + ", channelName=" + channelName + ", title=" + title + ", viewCnt="
				+ viewCnt + ", thumbnails=" + thumbnails + "]";
	}
	
	
}