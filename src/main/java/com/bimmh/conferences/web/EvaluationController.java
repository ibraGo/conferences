package com.bimmh.conferences.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.model.Evaluation;
import com.bimmh.conferences.repository.PresentationRepository;
import com.bimmh.conferences.repository.UserRepository;

@Controller
@RequestMapping(path = "/admin/evaluations")
public class EvaluationController extends AbstractCRUDController<Evaluation, Long> {

	@Autowired
	private PresentationRepository presentationRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void modelAttributes(Model model) {
		model.addAttribute("presentations",
				presentationRepository.findByProgramSectionStartDateGreaterThan(new Date()));
		model.addAttribute("users", userRepository.findByRoleName("ROLE_REVIEWER"));
	}

	@Override
	public Evaluation newInstance() {
		return new Evaluation();
	}

	@Override
	public String modelId() {
		return "evaluation";
	}

}
