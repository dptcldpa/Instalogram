package com.dptcldpa.instalogram.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dptcldpa.instalogram.comment.service.CommentService;

import jakarta.servlet.http.HttpSession;

@RestController
public class CommentRestController {
	
	private CommentService commentService;
	
	public CommentRestController(CommentService commentService) {
		this.commentService = commentService;
	}
	

	@PostMapping("/post/comment/create")
	public Map<String, String> createComment(
			@RequestParam("postId") int postId
			, @RequestParam("comments") String comments
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(commentService.addcomment(postId, userId, comments)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");			
		}
		
		return resultMap;
		
	}
	
}
