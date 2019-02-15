package com.bimmh.conferences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
