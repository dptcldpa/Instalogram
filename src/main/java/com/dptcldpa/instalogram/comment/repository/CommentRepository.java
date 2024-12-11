package com.dptcldpa.instalogram.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dptcldpa.instalogram.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
