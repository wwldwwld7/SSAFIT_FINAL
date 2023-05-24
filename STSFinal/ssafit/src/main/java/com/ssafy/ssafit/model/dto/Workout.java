package com.ssafy.ssafit.model.dto;

import java.sql.Timestamp;

public class Workout {
	private String nickName;
	private String workoutName;
	private int workoutCnt;
	private int workoutSetCnt;
	private String createdDate;
	private int workoutId;
	
	public Workout() {
	}

	public Workout(String nickName, String workoutName, int workoutCnt, int workoutSetCnt, String createdDate,
			int workoutId) {
		super();
		this.nickName = nickName;
		this.workoutName = workoutName;
		this.workoutCnt = workoutCnt;
		this.workoutSetCnt = workoutSetCnt;
		this.createdDate = createdDate;
		this.workoutId = workoutId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}

	public int getWorkoutCnt() {
		return workoutCnt;
	}

	public void setWorkoutCnt(int workoutCnt) {
		this.workoutCnt = workoutCnt;
	}

	public int getWorkoutSetCnt() {
		return workoutSetCnt;
	}

	public void setWorkoutSetCnt(int workoutSetCnt) {
		this.workoutSetCnt = workoutSetCnt;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	@Override
	public String toString() {
		return "Workout [nickName=" + nickName + ", workoutName=" + workoutName + ", workoutCnt=" + workoutCnt
				+ ", workoutSetCnt=" + workoutSetCnt + ", createdDate=" + createdDate + ", workoutId=" + workoutId
				+ "]";
	}
	
	
	
	
}
