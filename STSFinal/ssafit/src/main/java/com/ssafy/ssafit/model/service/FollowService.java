package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Follow;
import com.ssafy.ssafit.model.dto.User;

public interface FollowService {
	
	int addFollow(Follow follow);
	
	int removeFollow(Follow follow);
	
	List<User> searchByFollower(String follower);
	
	List<User> searchByFollowing(String following);
}
