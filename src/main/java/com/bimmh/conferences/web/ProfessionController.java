package com.bimmh.conferences.web;

import com.bimmh.conferences.validator.ProfessionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.model.Profession;

@Controller
@RequestMapping(path = "/admin/professions")
public class ProfessionController extends AbstractCRUDController<Profession, Long> {

	@Autowired
	ProfessionValidator professionValidator;

	@Override
	public Profession newInstance() {
		return new Profession();
	}

	@Override
	public String modelId() {
		return "profession";
	}

	@Override
	public Validator getValidator() {
		return professionValidator;
	}

	@Override
	public String getPath() {
		return "admin/professions";
	}

}
