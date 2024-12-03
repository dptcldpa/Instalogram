package com.dptcldpa.instalogram.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
	
	
	@GetMapping("/signup-view")
	public String inputJoin() {
		
		return "user/signup";
		
	}
	
	@GetMapping("/login-view")
	public String inputLogin() {
		
		return "user/login";
	}
	
}
