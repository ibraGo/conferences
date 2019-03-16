package com.bimmh.conferences.service;

import java.util.List;

import com.bimmh.conferences.model.Article;

public interface ArticleService {

	Article getById(long id);

	List<Article> getAll();

	void save(Article article);
}
