package com.bimmh.conferences.web;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bimmh.conferences.model.User;
import com.bimmh.conferences.repository.RoleRepository;
import com.bimmh.conferences.repository.UserRepository;

@Controller
@RequestMapping(path = "/admin/reviewers")
public class ReviewerController {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("reviewers", userRepository.findByRoleName("ROLE_REVIEWER"));
		return "admin/reviewers/list.html";
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String create(Model model) {
		String[] roles = { "ROLE_REVIEWER", "ROLE_ADMIN" };
		model.addAttribute("users", userRepository.findByRoleNameNotIn(Arrays.asList(roles)));
		return "admin/reviewers/add.html";
	}

	@RequestMapping(path = "/save/{id}", method = RequestMethod.GET)
	public String save(@PathVariable(value = "id") Long id) {
		User user = userRepository.findOne(id);
		user.setRole(roleRepository.findByName("ROLE_REVIEWER"));
		userRepository.save(user);
		return "redirect:/admin/reviewers/add";
	}

}
