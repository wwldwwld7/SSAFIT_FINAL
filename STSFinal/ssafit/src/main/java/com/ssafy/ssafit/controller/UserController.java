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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/signUp")
	public ResponseEntity<?> singUp(User user){
		int result = userService.createUser(user);
		if(result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> logIn(User user, HttpSession session){
		
		Map<String, Object> result = new HashMap<String, Object>();
		//Vue에서 axios를 통해 User가 들어올거임
		//user를 이용해서 Service->Dao->DB를 통해 실제 유저인지 확인해야한다.
		User tmp = userService.loginUser(user);
//		System.out.println(tmp.toString());
		HttpStatus status = null;
		try {
			if(tmp != null) {
				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
				result.put("message", "SUCCESS");
				status = HttpStatus.ACCEPTED;
				session.setAttribute("logInUser", tmp);
			}
			else {
				result.put("message", "FAIL");
				status = HttpStatus.NO_CONTENT;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", "FAIL");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		
		return new ResponseEntity<Map<String,Object>>(result, status);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logOut(HttpSession session){
		if(session.getAttribute("logInUser") != null) {
			System.out.println(session.getAttribute("logInUser"));
			session.removeAttribute("logInUser");
			System.out.println(session.getAttribute("logInUser"));
			session.invalidate();
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		System.out.println(session.getAttribute("logInUser"));
		return new ResponseEntity<String>("NO_CONTENT", HttpStatus.OK);
	}
	
}
