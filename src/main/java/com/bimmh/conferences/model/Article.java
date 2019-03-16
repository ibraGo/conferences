package com.bimmh.conferences.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String fileName;
	@Column(columnDefinition = "text")
	private String articleAbstract;

	@ManyToMany
	private Set<Profession> professions;

	@ManyToMany
	private Set<User> authors;

	@ManyToOne
	private Conference conference;

	@OneToMany(mappedBy = "article")
	private Set<Review> reviews;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Profession> getProfessions() {
		return professions;
	}

	public void setProfessions(Set<Profession> professions) {
		this.professions = professions;
	}

	public Set<User> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<User> authors) {
		this.authors = authors;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

}
