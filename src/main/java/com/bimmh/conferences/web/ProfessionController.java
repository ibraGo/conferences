package com.bimmh.conferences.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.model.Profession;

@Controller
@RequestMapping(path = "/admin/professions")
public class ProfessionController extends AbstractCRUDController<Profession, Long> {

	@Override
	public Profession newInstance() {
		return new Profession();
	}

	@Override
	public String modelId() {
		return "profession";
	}

}
