package com.dptcldpa.instalogram.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dptcldpa.instalogram.comment.domain.Comment;

import jakarta.transaction.Transactional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	// WHERE `postId` = #{}
	public List<Comment> findByPostId(int postId);
	
	// DELETE FROM `comment` WHERE `postId` = #{}
	@Transactional
	public void deleteByPostId(int postId);
	
}
