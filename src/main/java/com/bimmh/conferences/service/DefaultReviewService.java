package com.bimmh.conferences.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimmh.conferences.model.Review;
import com.bimmh.conferences.repository.ReviewRepository;

@Service
public class DefaultReviewService implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public Review getById(long id) {
		return reviewRepository.findOne(id);
	}

	@Override
	public List<Review> getAll() {
		return reviewRepository.findAll();
	}

	@Override
	public void save(Review review) {
		reviewRepository.save(review);
	}

	@Override
	public void saveOrUpdate(Review review) {
		List<Review> reviews = reviewRepository.findByArticleAndReviewer(review.getArticle(), review.getReviewer());

		if (reviews.size() > 0) {
			review.setId(reviews.get(0).getId());
		}
		reviewRepository.save(review);

		// if()
		// TODO send email

	}

}
