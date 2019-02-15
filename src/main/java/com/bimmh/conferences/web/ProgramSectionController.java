package com.bimmh.conferences.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.model.ProgramSection;
import com.bimmh.conferences.repository.ConferenceRepository;
import com.bimmh.conferences.repository.PresentationRepository;

@Controller
@RequestMapping(path = "/admin/programs_sections")
public class ProgramSectionController extends AbstractCRUDController<ProgramSection, Long> {

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

}
