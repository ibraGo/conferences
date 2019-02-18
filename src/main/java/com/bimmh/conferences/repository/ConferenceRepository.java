package com.bimmh.conferences.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {

	List<Conference> findByStartDateGreaterThanOrderByStartDateAsc(Date date);

	List<Conference> findByStartDateGreaterThan(Date date);
}
