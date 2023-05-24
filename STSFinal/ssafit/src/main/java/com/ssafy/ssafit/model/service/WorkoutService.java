package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Workout;

public interface WorkoutService {
	
	int addWorkout(Workout workout);
	
	int removeWorkout(int workoutId);
	
	List<Workout> myWorkout(String nickName);
	
}
