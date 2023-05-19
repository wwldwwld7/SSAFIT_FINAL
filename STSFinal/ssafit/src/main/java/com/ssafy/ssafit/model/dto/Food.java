package com.ssafy.ssafit.model.dto;

import java.sql.Timestamp;

public class Food {
	private String nickName;
	private String foodName;
	private int kcal;
	private Timestamp createdDate;
	private int foodId;
	
	public Food() {
	}

	public Food(String nickName, String foodName, int kcal, Timestamp createdDate, int foodId) {
		super();
		this.nickName = nickName;
		this.foodName = foodName;
		this.kcal = kcal;
		this.createdDate = createdDate;
		this.foodId = foodId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	@Override
	public String toString() {
		return "Food [nickName=" + nickName + ", foodName=" + foodName + ", kcal=" + kcal + ", createdDate="
				+ createdDate + ", foodId=" + foodId + "]";
	}
	
	
}
