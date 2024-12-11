package com.dptcldpa.instalogram.like.service;

import org.springframework.stereotype.Service;

import com.dptcldpa.instalogram.like.domain.Like;
import com.dptcldpa.instalogram.like.repository.LikeRepository;

@Service
public class LikeService {
	
	private LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	public boolean addLike(int postId, int userId) {
		
		Like like = Like.builder()
				.postId(postId)
				.userId(userId)
				.build();
		try {
			likeRepository.save(like);
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}

}
