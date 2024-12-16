package com.dptcldpa.instalogram.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dptcldpa.instalogram.like.service.LikeService;

import jakarta.servlet.http.HttpSession;

@RestController
public class LikeRestController {
	
	private LikeService likeService;
	
	public LikeRestController(LikeService likeService) {
		this.likeService = likeService;
	}
	
	@PostMapping("/post/like")
	public Map<String, String> like(
			@RequestParam("postId") int postId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(likeService.addLike(postId, userId)) {
			resultMap.put("reuslt", "success");
		} else {
			resultMap.put("reuslt", "fail");
		}
		
		return resultMap;
		
	}
	
	@DeleteMapping("/post/unlike")
	public Map<String, String> unlike(
			@RequestParam("postId") int postId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(likeService.deleteLike(postId, userId)) {
			resultMap.put("reuslt", "success");
		} else {
			resultMap.put("reuslt", "fail");
		}
		
		return resultMap;
		
	}

}
