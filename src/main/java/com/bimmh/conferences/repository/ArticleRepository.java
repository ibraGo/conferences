package com.bimmh.conferences.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bimmh.conferences.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	@Query("SELECT a FROM Article a where size(a.reviews) < 3")
	@EntityGraph(value = "Article.professions")
	List<Article> findArticleForReviewByProfessions();
}
