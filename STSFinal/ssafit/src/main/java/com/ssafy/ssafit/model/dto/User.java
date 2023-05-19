package com.ssafy.ssafit.model.dto;

public class User {
	private String userId;
	private String name;
	private String password;
	private String nickName;
	private String stateMsg;
	private int lastingCnt;
	
	public User() {
	}

	public User(String userId, String name, String password, String nickName, String stateMsg, int lastingCnt) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.nickName = nickName;
		this.stateMsg = stateMsg;
		this.lastingCnt = lastingCnt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getStateMsg() {
		return stateMsg;
	}

	public void setStateMsg(String stateMsg) {
		this.stateMsg = stateMsg;
	}

	public int getLastingCnt() {
		return lastingCnt;
	}

	public void setLastingCnt(int lastingCnt) {
		this.lastingCnt = lastingCnt;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", nickName=" + nickName
				+ ", stateMsg=" + stateMsg + ", lastingCnt=" + lastingCnt + "]";
	}
	
	
}
