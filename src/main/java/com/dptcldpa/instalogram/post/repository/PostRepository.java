package com.dptcldpa.instalogram.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dptcldpa.instalogram.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	
	
}
