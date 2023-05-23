package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.LikeVideo;
import com.ssafy.ssafit.model.service.LikeVideoService;

@RestController
@RequestMapping("/like")
@CrossOrigin("*")
public class LikeVideoController {
	
	private LikeVideoService likeVideoService;
	
	@Autowired
	public LikeVideoController(LikeVideoService likeVideoService) {
		this.likeVideoService = likeVideoService;
	}
	
	@PostMapping
	public ResponseEntity<?> addLikeVideo(@RequestBody LikeVideo likeVideo){
		int result = likeVideoService.addLikeVideo(likeVideo);
		if(result==0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{nickName}/{youtubeId}")
	public ResponseEntity<?> removeLikeVideo(@PathVariable String nickName, @PathVariable String youtubeId){
		int result = likeVideoService.removeLikeVideo(nickName, youtubeId);
		if(result==0) {
			System.out.println("삭제할게 없어");
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/start/{nickName}/{youtubeId}")
	public ResponseEntity<?> searchOne(@PathVariable String nickName, @PathVariable String youtubeId){
		System.out.println("시작하면 들어오니?");
		LikeVideo tmp = likeVideoService.searchOne(nickName, youtubeId);
		if(tmp==null) {
			System.out.println("없엉");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@GetMapping("/{nickName}")
	public ResponseEntity<?> searchByNickName(@PathVariable String nickName){
		List<LikeVideo> list = likeVideoService.searchByNickName(nickName);
		if(list==null || list.size()==0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LikeVideo>>(list, HttpStatus.OK);	
	}
}
