package com.dptcldpa.instalogram.like.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dptcldpa.instalogram.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {

	// SELECT count(*) FROM `like` WHERE `postId` = #{}
	public int countByPostId(int postId);
	
	// SELECT count(*) FROM `like` WHERE `postId` = #{} AND `userId` = #{}
	public int countByPostIdAndUserId(int postId, int userId);
	
	public Optional<Like> findByPostIdAndUserId(int postId, int userId);
	
}
