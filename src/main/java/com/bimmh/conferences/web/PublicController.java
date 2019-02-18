package com.bimmh.conferences.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.repository.ArticleRepository;
import com.bimmh.conferences.repository.ConferenceRepository;
import com.bimmh.conferences.repository.ProgramSectionRepository;

@Controller
public class PublicController {

	@Autowired
	private ConferenceRepository conferenceRepository;

	@Autowired
	private ProgramSectionRepository programSectionRepository;

	@Autowired
	private ArticleRepository articleRepository;

	@RequestMapping(path = { "/", "/index" })
	public String index(Model model) {
		model.addAttribute("conferences",
				conferenceRepository.findByStartDateGreaterThanOrderByStartDateAsc(new Date()));

		model.addAttribute("articles", articleRepository.findAll());

		return "index.html";
	}

	@RequestMapping(path = "/scheduler/{id}")
	public String schudlerConference(Model model, @PathVariable(value = "id") Long id) {
//		Conference conference = conferenceRepository.findOne(id);
//		Set<ProgramSection> programSections = programSectionRepository.findByConference(id);
//		model.addAttribute("programSections", programSections);
//		model.addAttribute("conference", conference);

		return "scheduler.html";
	}

}
