package com.bimmh.conferences.web;

import com.bimmh.conferences.model.User;
import com.bimmh.conferences.validator.ConferenceValidator;
import com.bimmh.conferences.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.model.Conference;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/admin/conferences")
public class ConferenceController extends AbstractCRUDController<Conference, Long> {


	@Autowired
	private ConferenceValidator conferenceValidator;

	@Override
	public Conference newInstance() {
		return new Conference();
	}

	@Override
	public String modelId() {
		return "conference";
	}

	@Override
	public Validator getValidator() {
		return conferenceValidator;
	}

    @Override
    public String getPath() {
        return "admin/conferences";
    }

}
