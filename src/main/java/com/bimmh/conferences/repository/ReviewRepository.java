package com.bimmh.conferences.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.Article;
import com.bimmh.conferences.model.Review;
import com.bimmh.conferences.model.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findByArticleAndReviewer(Article article, User reviewer);

	List<Review> findByArticleAndReviewer(Article article);
}
