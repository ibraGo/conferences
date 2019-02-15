package com.bimmh.conferences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
