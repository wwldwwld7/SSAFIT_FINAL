package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.LikeVideo;

public interface LikeVideoDao {
	
	int insertLikeVideo(LikeVideo likeVideo);
	
	int deleteLikeVideo(String nickName, String youtubeId);
	
	LikeVideo selectOne(String nickName, String youtubeId); //영상 디테일에 들어갔을 때 내가 찜한 영상인이 아닌지 알기 위해
	
	List<LikeVideo> selectByNickName(String nickName); //내가 or 다른 사람이 찜한 영상들 리스트
	
}
