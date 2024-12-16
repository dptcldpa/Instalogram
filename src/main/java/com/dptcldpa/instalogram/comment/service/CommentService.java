package com.dptcldpa.instalogram.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dptcldpa.instalogram.comment.domain.Comment;
import com.dptcldpa.instalogram.comment.dto.CommentDTO;
import com.dptcldpa.instalogram.comment.repository.CommentRepository;
import com.dptcldpa.instalogram.user.domain.User;
import com.dptcldpa.instalogram.user.service.UserService;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	private UserService userService;
	
	public CommentService(
			CommentRepository commentRepository
			, UserService  userService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
	}

	public boolean addcomment(int postId, int userId, String comments) {
		
		Comment comment = Comment.builder()
				.postId(postId)
				.userId(userId)
				.comments(comments)
				.build();
		
		try {
			commentRepository.save(comment);
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}
	
	public List<CommentDTO> getCommentList(int postId) {
		
		List<Comment> commentList = commentRepository.findByPostId(postId);
		
		List<CommentDTO> commentDTOList = new ArrayList<>();
		for(Comment comment:commentList) {
			
			int userId = comment.getUserId();
			
			User user = userService.getUserById(userId);
			
			CommentDTO commentDTO = CommentDTO.builder()
					.commentId(comment.getId())
					.userId(userId)
					.loginId(user.getLoginId())
					.comments(comment.getComments())
					.build();
			
			commentDTOList.add(commentDTO);
			
		}
		return commentDTOList;
		
	}	
	
	public void deleteCommentByPostId(int postId) {
		
		commentRepository.deleteByPostId(postId);
		
	}
	
}
