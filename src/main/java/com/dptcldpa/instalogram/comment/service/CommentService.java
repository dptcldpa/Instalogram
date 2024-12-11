package com.dptcldpa.instalogram.comment.service;

import org.springframework.stereotype.Service;

import com.dptcldpa.instalogram.comment.domain.Comment;
import com.dptcldpa.instalogram.comment.repository.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
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
	
}
