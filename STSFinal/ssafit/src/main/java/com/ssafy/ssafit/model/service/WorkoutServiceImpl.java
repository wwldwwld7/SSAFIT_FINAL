package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.WorkoutDao;
import com.ssafy.ssafit.model.dto.Workout;

@Service
public class WorkoutServiceImpl implements WorkoutService {
	
	private WorkoutDao workoutDao;
	
	@Autowired
	public WorkoutServiceImpl(WorkoutDao workoutDao) {
		this.workoutDao = workoutDao;
	}

	@Override
	public int addWorkout(Workout workout) {
		return workoutDao.inserWorkout(workout);
	}

	@Override
	public int removeWorkout(int workoutId) {
		return workoutDao.deleteWorkout(workoutId);
	}

	@Override
	public List<Workout> myWorkout(String nickName) {
		return workoutDao.selectMyWorkout(nickName);
	}

}
