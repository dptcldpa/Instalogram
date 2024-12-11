package com.dptcldpa.instalogram.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dptcldpa.instalogram.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {

}
