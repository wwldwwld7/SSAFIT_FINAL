package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Workout;
import com.ssafy.ssafit.model.service.WorkoutService;

@RestController
@RequestMapping("/workout")
@CrossOrigin("*")
public class WorkoutController {
	
	private WorkoutService workoutService;
	
	@Autowired
	public WorkoutController(WorkoutService workoutService) {
		this.workoutService = workoutService;
	}
	
	@PostMapping("")
	public ResponseEntity<?> addWorkout(@RequestBody Workout workout){
		int result = workoutService.addWorkout(workout);
		if(result==0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/my/{nickName}")
	public ResponseEntity<?> myWokrout(@PathVariable String nickName){
		List<Workout> list = workoutService.myWorkout(nickName);
		if(list==null || list.size()==0) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Workout>>(list, HttpStatus.OK);
	}

}
