package com.bimmh.conferences.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.repository.ConferenceRepository;

@Service
public class DefaultConferenceService implements ConferenceService {

	@Autowired
	ConferenceRepository conferenceRepository;

	@Override
	public List<Conference> currentConferences(Date date) {
		return conferenceRepository.findByStartDateGreaterThanOrderByStartDateAsc(date);
	}

	@Override
	public Conference getByID(long id) {
		return conferenceRepository.findOne(id);
	}

}
