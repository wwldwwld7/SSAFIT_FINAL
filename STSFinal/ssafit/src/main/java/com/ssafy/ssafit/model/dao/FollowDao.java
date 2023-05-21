package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Follow;
import com.ssafy.ssafit.model.dto.User;

public interface FollowDao {
	
	int insertFollow(Follow follow);
	
	int deleteFollow(Follow follow);
	
	List<User> selectByFollower(String nickName); //내가 팔로우 하는 사람들 리스트
	
	List<User> selectByFollowing(String nickName); //나를 팔로우 하는 사람들 리스트
}
