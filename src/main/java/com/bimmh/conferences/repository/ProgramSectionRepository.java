package com.bimmh.conferences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.ProgramSection;

public interface ProgramSectionRepository extends JpaRepository<ProgramSection, Long> {
}
