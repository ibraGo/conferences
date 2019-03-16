package com.bimmh.conferences.service;

import java.util.Date;
import java.util.List;

import com.bimmh.conferences.model.Conference;

public interface ConferenceService {

	Conference getByID(long id);

	List<Conference> currentConferences(Date date);

}
