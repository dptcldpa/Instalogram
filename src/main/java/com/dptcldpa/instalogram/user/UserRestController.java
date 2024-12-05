package com.dptcldpa.instalogram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dptcldpa.instalogram.user.domain.User;
import com.dptcldpa.instalogram.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	private UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/signup")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("email") String email) {
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(userService.addUser(loginId, password, name, email)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");			
		}
		
		return resultMap;
		
	}
	
	@GetMapping("/duplicated-id")
	public Map<String, Boolean> isDuplicated(@RequestParam("loginId") String loginId){
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		resultMap.put("isduplicated", userService.isDuplicatedId(loginId));
		
		return resultMap;
		
	}
	
	@PostMapping("/login")
	public Map<String, String> login(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpSession session) {
		
		User user = userService.getUser(loginId, password);
				
		Map<String, String> resultMap = new HashMap<>();

		if(user != null) {
			
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			
			
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");			
		}
		
		return resultMap;
		
	}
	
}
