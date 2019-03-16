package com.bimmh.conferences.web;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.model.ProgramSection;
import com.bimmh.conferences.service.ArticleService;
import com.bimmh.conferences.service.ConferenceService;
import com.bimmh.conferences.service.ProgramSectionService;

@Controller
public class PublicController {

	@Autowired
	private ConferenceService conferenceService;

	@Autowired
	private ProgramSectionService programSectionService;

	@Autowired
	private ArticleService articleService;

	@RequestMapping(path = { "/", "/index" })
	public String index(Model model) {
		model.addAttribute("conferences", conferenceService.currentConferences(new Date()));

		model.addAttribute("articles", articleService.getAll());

		return "index.html";
	}

	@RequestMapping(path = "/scheduler/{conferenceId}")
	public String schudlerConference(@PathVariable(value = "conferenceId") Long id, Model model) {
		Conference conference = conferenceService.getByID(id);
		Set<ProgramSection> programSections = programSectionService.getByConference(conference);
		model.addAttribute("programSections", programSections);
		model.addAttribute("conference", conference);

		return "scheduler.html";
	}

}
