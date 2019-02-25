package com.bimmh.conferences.web;

import java.util.Date;

import com.bimmh.conferences.validator.ProgramSectionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.model.ProgramSection;
import com.bimmh.conferences.repository.ConferenceRepository;
import com.bimmh.conferences.repository.PresentationRepository;

@Controller
@RequestMapping(path = "/admin/programs_sections")
public class ProgramSectionController extends AbstractCRUDController<ProgramSection, Long> {

	@Autowired
	ProgramSectionValidator programSectionValidator;

	@Autowired
	private ConferenceRepository conferenceRepository;

	@Autowired
	private PresentationRepository presentationRepository;

	@Override
	public void modelAttributes(Model model) {
		model.addAttribute("conferences", conferenceRepository.findByStartDateGreaterThan(new Date()));
		model.addAttribute("presentations", presentationRepository.findByProgramSectionIsNull());
	}

	@Override
	public ProgramSection newInstance() {
		return new ProgramSection();
	}

	@Override
	public String modelId() {
		return "programs_section";
	}

	@Override
	public Validator getValidator() {
		return programSectionValidator;
	}

	@Override
	public String getPath() {
		return "admin/programs_sections";
	}

}
