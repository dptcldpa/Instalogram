package com.dptcldpa.instalogram.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dptcldpa.instalogram.post.domain.Post;
import com.dptcldpa.instalogram.post.service.PostService;

@RequestMapping("/post")
@Controller
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/timeline-view")
	public String timeLinePost(Model model) {
		
		List<Post> postList = postService.getPostList();
		
		model.addAttribute(postList)
		return "post/timeline";
	}
	
}
