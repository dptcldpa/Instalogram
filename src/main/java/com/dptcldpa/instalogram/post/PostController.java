package com.dptcldpa.instalogram.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dptcldpa.instalogram.post.dto.CardDTO;
import com.dptcldpa.instalogram.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/timeline-view")
	public String timeLinePost(
			Model model
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<CardDTO> cardList = postService.getPostList(userId);
		
		model.addAttribute("cardList", cardList);
		
		return "post/timeline";
	}
	
	@GetMapping("/create-view")
	public String createPost() {
		
		return "post/create";
	}
	
}
