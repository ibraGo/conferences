package com.bimmh.conferences.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimmh.conferences.model.Presentation;
import com.bimmh.conferences.repository.UserRepository;

@Controller
@RequestMapping(path = "/admin/presentations")
public class PresentationController extends AbstractCRUDController<Presentation, Long> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void modelAttributes(Model model) {
		model.addAttribute("speakers", userRepository.findByRoleName("ROLE_USER"));
	}

	@Override
	public Presentation newInstance() {
		return new Presentation();
	}

	@Override
	public String modelId() {
		return "presentation";
	}

}
