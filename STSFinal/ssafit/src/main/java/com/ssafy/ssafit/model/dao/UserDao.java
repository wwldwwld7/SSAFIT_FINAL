package com.ssafy.ssafit.model.dao;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	
	int insertUser(User user); //회원가입
	
	User selectOne(String userId); //로그인
	
}
