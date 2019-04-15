package com.bimmh.conferences.service;

import java.util.List;

import com.bimmh.conferences.model.Review;

public interface ReviewService {

	Review getById(long id);

	List<Review> getAll();

	void save(Review review);

	void saveOrUpdate(Review review);
}
