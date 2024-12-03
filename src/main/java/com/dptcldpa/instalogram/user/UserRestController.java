package com.dptcldpa.instalogram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dptcldpa.instalogram.user.service.UserService;

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
			, @RequestParam("email") String email
			, @RequestParam("bio") String bio
			, @RequestParam("profileImage") String profileImage) {
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(userService.addUser(loginId, password, name, email, bio, profileImage)) {
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
	
}
