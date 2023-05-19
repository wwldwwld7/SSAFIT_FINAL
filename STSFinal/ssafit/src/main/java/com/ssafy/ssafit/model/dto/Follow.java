package com.ssafy.ssafit.model.dto;

public class Follow {
	private String follower;
	private String following;
	private int followId;
	
	public Follow() {
	}

	public Follow(String follower, String following, int followId) {
		super();
		this.follower = follower;
		this.following = following;
		this.followId = followId;
	}

	public String getFollower() {
		return follower;
	}

	public void setFollower(String follower) {
		this.follower = follower;
	}

	public String getFollowing() {
		return following;
	}

	public void setFollowing(String following) {
		this.following = following;
	}

	public int getFollowId() {
		return followId;
	}

	public void setFollowId(int followId) {
		this.followId = followId;
	}

	@Override
	public String toString() {
		return "Follow [follower=" + follower + ", following=" + following + ", followId=" + followId + "]";
	}
	
	
}
