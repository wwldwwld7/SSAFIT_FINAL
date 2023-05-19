package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {
	
	//메인화면에 보여지는 기본 영화 리스트
	List<Video> selectAll();
	
	//youtubeId로 영화 하나만 검색 ( detail 들어갈 때 필요 )
	Video selectOne(String youtubeId);
	
	//keyword가 포함된 영화들을 검색 ( 검색창에 keyword로 검색할 때 필요)
	List<Video> selectByTitle(String keyword);
	
}
