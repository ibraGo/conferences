package com.bimmh.conferences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
