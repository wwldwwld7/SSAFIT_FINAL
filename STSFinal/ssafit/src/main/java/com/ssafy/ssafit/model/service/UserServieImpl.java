package com.ssafy.ssafit.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.User;

@Service
public class UserServieImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserServieImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int createUser(User user) { //회원가입
		return userDao.insertUser(user);
	}

	@Override
	public User loginUser(String userId) { //로그인, 회원가입시 아이디 중복 확인
		User tmp = userDao.selectOne(userId);
		if(tmp==null)
			return null;
		return tmp;
	}

	@Override
	public User nickNameCheck(String nickName) { //닉네임 중복확인
		User tmp = userDao.selectByNickName(nickName);
		if(tmp==null)
			return null;
		return tmp;
	}

	@Override
	public int modifyUser(User user) {
		return userDao.updateUser(user);
	}

}
