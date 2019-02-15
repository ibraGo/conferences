package com.bimmh.conferences.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.model.Conference;

@Controller
@RequestMapping(path = "/admin/conferences")
public class ConferenceController extends AbstractCRUDController<Conference, Long> {

	@Override
	public Conference newInstance() {
		return new Conference();
	}

	@Override
	public String modelId() {
		return "conference";
	}

}
