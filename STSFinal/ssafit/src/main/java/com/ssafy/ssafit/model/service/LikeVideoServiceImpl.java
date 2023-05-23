package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.LikeVideoDao;
import com.ssafy.ssafit.model.dto.LikeVideo;

@Service
public class LikeVideoServiceImpl implements LikeVideoService {
	
	private LikeVideoDao likeVideoDao;
	
	@Autowired
	public LikeVideoServiceImpl(LikeVideoDao likeVideoDao) {
		this.likeVideoDao = likeVideoDao;
	}

	@Override
	public int addLikeVideo(LikeVideo likeVideo) {
		return likeVideoDao.insertLikeVideo(likeVideo);
	}

	@Override
	public int removeLikeVideo(String nickName, String youtubeId) {
		return likeVideoDao.deleteLikeVideo(nickName, youtubeId);
	}

	@Override
	public LikeVideo searchOne(String nickName, String youtubeId) {
		return likeVideoDao.selectOne(nickName, youtubeId);
	}

	@Override
	public List<LikeVideo> searchByNickName(String nickName) {
		return likeVideoDao.selectByNickName(nickName);
	}

}
