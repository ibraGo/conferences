package com.bimmh.conferences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
