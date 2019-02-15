package com.bimmh.conferences.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evaluations")
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Float note;

	@ManyToOne
	private User judge;

	@ManyToOne
	private Presentation presentation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public User getJudge() {
		return judge;
	}

	public void setJudge(User judge) {
		this.judge = judge;
	}

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}

}
