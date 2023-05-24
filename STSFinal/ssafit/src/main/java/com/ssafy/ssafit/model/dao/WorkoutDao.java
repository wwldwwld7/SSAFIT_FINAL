package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Workout;

public interface WorkoutDao {
	
	int inserWorkout(Workout workout);
	
	int deleteWorkout(int workoutId);
	
	List<Workout> selectMyWorkout(String nickName);
	
}
