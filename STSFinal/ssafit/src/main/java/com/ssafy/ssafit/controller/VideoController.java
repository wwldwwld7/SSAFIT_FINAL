package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

@RestController
@RequestMapping("/video")
public class VideoController {

	VideoService videoService;
	
	@Autowired
	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}
	
	//메인화면에 보여지는 기본 영화 리스트
	@GetMapping
	public ResponseEntity<List<Video>> searchAll() {
		List<Video> list = videoService.searchAll();
		
		if(list.size() == 0 || list == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	}
	
	//youtubeId로 영화 하나만 검색 ( detail 들어갈 때 필요 )
	@GetMapping("/detail/{youtubeId}")
	public ResponseEntity<Video> searchOne(@PathVariable String youtubeId) {
		Video video = videoService.searchOne(youtubeId);
		
		if(video == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(video, HttpStatus.OK);
		}
	}
	
	//keyword가 포함된 영화들을 검색 ( 검색창에 keyword로 검색할 때 필요)
	@GetMapping("/{keyword}")
	public ResponseEntity<List<Video>> searchByTitle(@PathVariable String keyword) {
		List<Video> list = videoService.searchByTitle(keyword);
		
		if(list.size() == 0 || list == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	}
	
//	@GetMapping("/{keyword}")
//	public ResponseEntity<List<Video>> searchByTitle(@PathVariable String keyword) {
//		Video video = videoService.searchByTitle(keyword);
//		
//		if(null이면 추가하고) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}else {아니면 지나가(selectOne으로 이어져)
					//연결이면 이어져~하고 걍따로할거면 그냥이부분없어도됨 (아래부분 )
//			return new ResponseEntity<>(list, HttpStatus.OK);
//		}
//	}

	
}
