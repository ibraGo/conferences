package com.bimmh.conferences.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimmh.conferences.model.Article;
import com.bimmh.conferences.repository.ArticleRepository;

@Service
public class DefaultArticleService implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	@Override
	public Article getById(long id) {
		return articleRepository.findOne(id);
	}

	@Override
	public List<Article> getAll() {
		return articleRepository.findAll();
	}

	@Override
	public void save(Article article) {
		articleRepository.save(article);
	}

}
