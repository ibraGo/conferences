package com.bimmh.conferences.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.Presentation;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {
	List<Presentation> findByProgramSectionIsNull();

	List<Presentation> findByProgramSectionStartDateGreaterThan(Date date);
}
