package com.ssafy.ssafit.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;
import com.ssafy.ssafit.util.JwtUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
//	@Autowired
	private JwtUtil jwtUtil;
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService, JwtUtil jwtUtil) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> singUp(@RequestBody User user){
		int result = userService.createUser(user);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> logIn(@RequestBody User user, HttpSession session){
		Map<String, Object> result = new HashMap<String, Object>();
		//Vue에서 axios를 통해 User가 들어올거임
		//user를 이용해서 Service->Dao->DB를 통해 실제 유저인지 확인해야한다.
		User tmp = userService.loginUser(user.getUserId());
		HttpStatus status = null;
		try {
			if(tmp == null) {
				result.put("message", "FAIL");
				status = HttpStatus.BAD_REQUEST;
			}
			else if(tmp.getPassword().equals(user.getPassword())) {
//				result.put("access-token", jwtUtil.createToken("id",tmp.getUserId()));
				result.put("userId", tmp.getUserId());
				result.put("message", "SUCCESS");
				result.put("name", tmp.getName());
				result.put("nickName", tmp.getNickName());
				result.put("stateMsg", tmp.getStateMsg());
				status = HttpStatus.ACCEPTED;
//				session.setAttribute("logInUser", tmp);
			}
			else {
				result.put("message", "FAIL");
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			result.put("message", "FAIL");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(result, status);
	}
	
//	@GetMapping("/logout")
//	public ResponseEntity<?> logOut(HttpSession session){
//		if(session.getAttribute("logInUser") != null) {
//			System.out.println(session.getAttribute("logInUser"));
//			session.removeAttribute("logInUser");
//			System.out.println(session.getAttribute("logInUser"));
//			session.invalidate();
//			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		}
//		System.out.println(session.getAttribute("logInUser"));
//		return new ResponseEntity<String>("NO_CONTENT", HttpStatus.OK);
//	}
	
	@GetMapping("/id_check/{userId}")
	public ResponseEntity<?> idCheck(@PathVariable String userId){
		User tmp = userService.loginUser(userId);
		if(tmp==null) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/nickname_check/{nickName}")
	public ResponseEntity<?> nicknameCheck(@PathVariable String nickName){
		User tmp = userService.nickNameCheck(nickName);
		if(tmp==null) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<?> modifyUser(@RequestBody User user){
		int result = userService.modifyUser(user);
//		System.out.println(tmp.toString());
		if(result == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		User tmp = userService.loginUser(user.getUserId());
		return new ResponseEntity<User>(tmp, HttpStatus.OK);
	}
	
//	@GetMapping("/user_info/{nickName}")
//	public ResponseEntity<?> user_info(@PathVariable String nickName){
//		User tmp = userService.nickNameCheck(nickName);
//		if(tmp==null) {
//			return new ResponseEntity<User>(tmp, HttpStatus.OK);
//		}
//		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//	}
	
}
