package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Follow;
import com.ssafy.ssafit.model.dto.User;

public interface FollowDao {
	
	int insertFollow(Follow follow);
	
	int deleteFollow(String follower, String following);
	
	List<User> selectByFollower(String follower); //내가 팔로우 하는 사람들 리스트
	
	List<User> selectByFollowing(String following); //나를 팔로우 하는 사람들 리스트
	
	Follow selectRelation(String follower, String following);
}
