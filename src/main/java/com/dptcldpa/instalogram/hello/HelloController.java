package com.dptcldpa.instalogram.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		
		return "hello World!!! :) in instagram";
		
	}
	
}
