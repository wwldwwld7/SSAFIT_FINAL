package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.LikeVideo;

public interface LikeVideoService {
	
	int addLikeVideo(LikeVideo likeVideo);
	
	int removeLikeVideo(String nickName, String youtubeId);
	
	LikeVideo searchOne(String nickName, String youtubeId);
	
	List<LikeVideo> searchByNickName(String nickName);

}
