package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.VideoDao;
import com.ssafy.ssafit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {
	
	private VideoDao videoDao;
	
	@Autowired
	public VideoServiceImpl(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
	//메인화면에 보여지는 기본 영화 리스트
	@Override
	public List<Video> searchAll() {
		return videoDao.selectAll();
	}
	
	//youtubeId로 영화 하나만 검색 ( detail 들어갈 때 필요 )
	@Override
	public Video searchOne(String youtubeId) {
		return videoDao.selectOne(youtubeId);
	}
	
	//keyword가 포함된 영화들을 검색 ( 검색창에 keyword로 검색할 때 필요)
	@Override
	public List<Video> searchByTitle(String keyword) {
		return videoDao.selectByTitle(keyword);
	}

	//youtubeId로 DB에 이 영상관련 정보가 이미 있는지 확인한다.
	@Override
	public Video searchByYoutubeId (String youtubeId) {
		return videoDao.selectByYoutubeId(youtubeId);
	}
	
	//영상 관련 정보가 없다면 새로 영상 정보를 DB에 저장한다.
	@Override
	public int registVideo(Video video) {
		return videoDao.insertVideo(video);
	}

}
