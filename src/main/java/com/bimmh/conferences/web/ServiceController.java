package com.bimmh.conferences.web;

import java.util.Date;

import com.bimmh.conferences.validator.ServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.model.Service;
import com.bimmh.conferences.repository.ConferenceRepository;

@Controller
@RequestMapping(path = "/admin/services")
public class ServiceController extends AbstractCRUDController<Service, Long> {

	@Autowired
	private ServiceValidator serviceValidator;

	@Autowired
	private ConferenceRepository conferenceRepository;

	@Override
	public void modelAttributes(Model model) {
		model.addAttribute("conferences", conferenceRepository.findByStartDateGreaterThan(new Date()));
	}

	@Override
	public Service newInstance() {
		return new Service();
	}

	@Override
	public String modelId() {
		return "service";
	}

	@Override
	public Validator getValidator() {
		return serviceValidator;
	}

	@Override
	public String getPath() {
		return "admin/services";
	}

}
