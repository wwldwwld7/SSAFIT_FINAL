package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Comment;
import com.ssafy.ssafit.model.service.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {

	private CommentService commentService;
	
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@PostMapping
	public ResponseEntity<?> registComment (@RequestBody Comment comment){
		if(commentService.registComment(comment) == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
	
	@GetMapping("/video/{youtubeId}")
	public ResponseEntity<?> searchByVideo(@PathVariable String youtubeId){
		List<Comment> list = commentService.searchCommentByVideo(youtubeId);

		if(list.size() == 0 || list == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/user/{nickName}")
	public ResponseEntity<?> searchByUser(@PathVariable String nickName){
		List<Comment> list = commentService.searchCommentByUser(nickName);
		if(list.size() == 0 || list == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{commentId}")
	public ResponseEntity<?> removeComment(@PathVariable int commentId){
		if(commentService.removeComment(commentId) == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> modifyComment(@RequestBody Comment comment){
		if(commentService.modifyComment(comment) == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
}
