package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Follow;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.FollowService;

@RestController
@RequestMapping("/follow")
@CrossOrigin("*")
public class FollowController {
	
	private FollowService followService;
	
	public FollowController(FollowService followService) {
		this.followService = followService;
	}
	
	@PostMapping
	public ResponseEntity<?> addFollow(@RequestBody Follow follow){
		int result = followService.addFollow(follow);
		if(result==0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{follower}/{following}")
	public ResponseEntity<?> removeFollow(@PathVariable String follower,@PathVariable String following){
		int result = followService.removeFollow(follower, following);
		if(result == 0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/to/{follower}")
	public ResponseEntity<?> searchByFollower(@PathVariable String follower){
		List<User> followings = followService.searchByFollower(follower);
		if(followings == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(followings, HttpStatus.OK);
	}
	
	@GetMapping("/from/{following}")
	public ResponseEntity<?> searchByFollowing(@PathVariable String following){
		List<User> followers = followService.searchByFollowing(following);
		if(followers==null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(followers, HttpStatus.OK);
	}
	
	@GetMapping("/{follower}/{following}")
	public ResponseEntity<?> searchRelation(@PathVariable String follower,@PathVariable String following){
		Follow follow = followService.searchRelation(follower, following);
		if(follow == null) {
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(follow, HttpStatus.OK);
		}
	}

}
