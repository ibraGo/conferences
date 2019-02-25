package com.bimmh.conferences.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@RequestMapping(value = { "/admin", "/admin/dashboard" }, method = RequestMethod.GET)
	public String conferences(Model model) {
		return "admin/index.html";
	}

}
