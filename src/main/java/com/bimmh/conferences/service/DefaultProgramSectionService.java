package com.bimmh.conferences.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.model.ProgramSection;
import com.bimmh.conferences.repository.ProgramSectionRepository;

@Service
public class DefaultProgramSectionService implements ProgramSectionService {

	@Autowired
	ProgramSectionRepository programSectionRepository;

	@Override
	public ProgramSection getByID(long id) {
		return programSectionRepository.findOne(id);
	}

	@Override
	public Set<ProgramSection> getByConference(Conference conference) {
		return programSectionRepository.findByConference(conference);
	}

}
