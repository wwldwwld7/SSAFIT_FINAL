package com.ssafy.ssafit.model.dao;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	
	int insertUser(User user); //회원가입
	
	User selectOne(String userId); //로그인
	
	User selectByNickName(String nickName); //닉네임 중복체크
	
	User updateUser(User user); //회원정보 수정
	
}
