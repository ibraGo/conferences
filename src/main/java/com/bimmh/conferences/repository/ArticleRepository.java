package com.bimmh.conferences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
