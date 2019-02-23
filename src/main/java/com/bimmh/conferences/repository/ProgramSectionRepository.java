package com.bimmh.conferences.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.model.ProgramSection;

public interface ProgramSectionRepository extends JpaRepository<ProgramSection, Long> {

	Set<ProgramSection> findByConference(Conference conference);
}
