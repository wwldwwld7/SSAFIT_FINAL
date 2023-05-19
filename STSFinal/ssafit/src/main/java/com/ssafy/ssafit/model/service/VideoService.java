package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {
	
	//메인화면에 보여지는 기본 영화 리스트
	List<Video> searchAll();
	
	//youtubeId로 영화 하나만 검색 ( detail 들어갈 때 필요 )
	Video searchOne(String youtubeId);
	
	//keyword가 포함된 영화들을 검색 ( 검색창에 keyword로 검색할 때 필요)
	List<Video> searchByTitle(String keyword);
	
	//youtubeId로 DB에 이 영상관련 정보가 이미 있는지 확인한다.
	Video searchByYoutubeId (String youtubeId);
	
	//영상 관련 정보가 없다면 새로 영상 정보를 DB에 저장한다.
	int registVideo(Video video);
	
}
