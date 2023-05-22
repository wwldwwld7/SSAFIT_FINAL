package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.FollowDao;
import com.ssafy.ssafit.model.dto.Follow;
import com.ssafy.ssafit.model.dto.User;

@Service
public class FollowServiceImpl implements FollowService {

	private FollowDao followDao;
	
	@Autowired
	public FollowServiceImpl(FollowDao followDao) {
		this.followDao = followDao;
	}
	
	@Override
	public int addFollow(Follow follow) {
		return followDao.insertFollow(follow);
	}

	@Override
	public int removeFollow(Follow follow) {
		return followDao.deleteFollow(follow);
	}

	@Override
	public List<User> searchByFollower(String follower) {
		return followDao.selectByFollower(follower);
	}

	@Override
	public List<User> searchByFollowing(String following) {
		return followDao.selectByFollowing(following);
	}

}
