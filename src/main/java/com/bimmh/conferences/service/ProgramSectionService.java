package com.bimmh.conferences.service;

import java.util.Set;

import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.model.ProgramSection;

public interface ProgramSectionService {

	ProgramSection getByID(long id);

	Set<ProgramSection> getByConference(Conference conference);

}
