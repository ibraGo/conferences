package com.bimmh.conferences.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.text.DateFormat;
import java.util.Set;
import java.util.regex.Pattern;

import javax.persistence.*;

@Entity
@Table(name = "conferences")
public class Conference {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private Integer durationDays;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startSubmission;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endSubmission;
	private  String fileName;

	@OneToMany(mappedBy = "conference")
	private Set<ProgramSection> programSections;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String file) {
		this.fileName = file;
	}

	@OneToMany(mappedBy = "conference")
	private Set<Service> Service;

	@ManyToMany
	private Set<User> participants;

	// private String docType;
	// private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<User> participants) {
		this.participants = participants;
	}

	public Integer getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(Integer durationDays) {
		this.durationDays = durationDays;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartSubmission() {
		return startSubmission;
	}

	public void setStartSubmission(Date startSubmission) {
		this.startSubmission = startSubmission;
	}

	public Date getEndSubmission() {
		return endSubmission;
	}

	public void setEndSubmission(Date endSubmission) {
		this.endSubmission = endSubmission;
	}

	public Set<ProgramSection> getProgramSections() {
		return programSections;
	}

	public void setProgramSections(Set<ProgramSection> programSections) {
		this.programSections = programSections;
	}

}
