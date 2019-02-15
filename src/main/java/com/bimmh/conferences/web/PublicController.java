package com.bimmh.conferences.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bimmh.conferences.service.SecurityService;
import com.bimmh.conferences.service.UserService;
import com.bimmh.conferences.validator.UserValidator;

@Controller
public class PublicController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

}
